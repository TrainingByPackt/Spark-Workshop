from typing import List

# python_hydra: List[int] = [1, 2, 3, 4, 5]
# print(type(python_hydra))
# python_hydra = "This is now a string"
# print(type(python_hydra))


tokens: List[str] = ["Settlements", "some", "centuries", "old", "and", "still",  "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background"]
lengths = list(map(lambda token: len(token), tokens))
print(lengths)