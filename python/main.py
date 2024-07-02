import yaml
from openai import OpenAI
import os


def load_questions(filename):
    with open(filename, "r") as file:
        data = yaml.safe_load(file)
        return data["questions"]


def main():
    base_prompt = """You are to read the following instructions provided by a user and respond based on the content of the message. If the user's message includes directives related to movement or actions, respond with a specific command. If the message contains no relevant directive or is empty, return an empty response.

    - If the instruction includes any variation of "move left", respond with: COMMAND_MOVE_LEFT.
    - If the instruction includes any phrase like "pick up the cup" or "grab the cup", respond with: COMMAND_PICK_UP_CUP.
    - If the instruction mentions "pick up the block" or "grab the block", respond with: COMMAND_PICK_UP_BLOCK.
    - If the instruction is empty or contains none of the above actions, respond with an empty string.

    Instructions:"
    """
    questions = load_questions("questions.yaml")
    client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))
    for q in questions:
        response = client.chat.completions.create(
            model="gpt-4o",
            messages=[
                {
                    "role": "user",
                    "content": base_prompt + q["question"],
                }
            ],
            temperature=0.7,
            max_tokens=64,
            top_p=1,
        )

        response_text = response.choices[0].message.content
        if response_text is not None:
            response_text = response_text.strip()
        expected = q["expected_answer"]
        if response_text == expected:
            print(
                f"\033[32mQuestion: {q['question']} | Expected: {expected} | Got: {response_text}\033[0m"
            )
        else:
            print(
                f"\033[31mQuestion: {q['question']} | Expected: {expected} | Got: {response_text}\033[0m"
            )


if __name__ == "__main__":
    main()
