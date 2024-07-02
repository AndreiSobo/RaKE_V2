from openai import OpenAI, api_key
import os

base_prompt = """You are to read the following instructions provided by a user and respond based on the content of the message. If the user's message includes directives related to movement or actions, respond with a specific command. If the message contains no relevant directive or is empty, return an empty response.

- If the instruction includes any variation of "move left", respond with: COMMAND_MOVE_LEFT.
- If the instruction includes any phrase like "pick up the cup" or "grab the cup", respond with: COMMAND_PICK_UP_CUP.
- If the instruction mentions "pick up the block" or "grab the block", respond with: COMMAND_PICK_UP_BLOCK.
- If the instruction is empty or contains none of the above actions, respond with an empty string.

Instructions:"
"""


while True:
    user_input = input("Instruction: ")
    client = OpenAI()

    response = client.chat.completions.create(
        model="gpt-4o",
        messages=[
            {
                "role": "user",
                "content": base_prompt + user_input,
            }
        ],
        temperature=0.7,
        max_tokens=64,
        top_p=1,
    )

    response_text = response.choices[0].message.content

    # if response_text == "COMMAND_MOVE_LEFT":
    #     os.system(
    #         "C:\\dev\\cpp\\vcpkg\\libfranka-master\\libfranka-master\\out\\build\\x64-Debug\\examples\\echo_robot_state.exe"
    #     )
    # elif response_text == "COMMAND_PICK_UP_CUP":
    #     os.system(
    #         "C:\\dev\\cpp\\vcpkg\\libfranka-master\\libfranka-master\\out\\build\\x64-Debug\\examples\\echo_robot_state.exe"
    #     )
    # elif response_text == "COMMAND_PICK_UP_BLOCK":
    #     os.system(
    #         "C:\\dev\\cpp\\vcpkg\\libfranka-master\\libfranka-master\\out\\build\\x64-Debug\\examples\\grasp_object.exe"
    #     )
    #
    if response_text == "COMMAND_MOVE_LEFT":
        print("move left")
    elif response_text == "COMMAND_PICK_UP_CUP":
        print("pick up cup")
    elif response_text == "COMMAND_PICK_UP_BLOCK":
        print("pick up block")
