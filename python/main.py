import yaml


def load_questions(filename):
    with open(filename, "r") as file:
        data = yaml.safe_load(file)
        return list(data["questions"])


def main():
    questions = load_questions("questions.yaml")
    for q in questions:
        print(q)


if __name__ == "__main__":
    main()
