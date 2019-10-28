from typing import List, Optional

words: List[str] = ["Settlements", "some", "centuries", "old", "and", "still", "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background"]
mapped1 = list(map(lambda token: len(token), words))  # lambda
mapped2 = [*(map(lambda token: len(token), words))]  # unpacking generalization


tup1 = "a",
tup2 = ()

print(type(tup1))
print(type(tup2))




# print(mapped1)
# print(mapped2)