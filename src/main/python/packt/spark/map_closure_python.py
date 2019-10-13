from packt.helper_python import create_session

if __name__ == "__main__":
    tokens = ["Settlements", "some", "centuries", "old", "and", "still",  "no", "bigger", "than", "pinheads", "on", "the",
              "untouched", "expanse", "of", "their", "background"]
    sparksession = create_session(2, "Python map closure")
    tokens_rdd = sparksession.sparkContext.parallelize(tokens) # Creation of Spark data structure

    tokenLengths = tokens_rdd.map(lambda token: len(token)) # passing a closure to Spark's `map`
    print(tokenLengths.collect()) # printing result to stdout
    # Result: [11, 4, 9, 3, 3, 5, 2, 6, 4, 8, 2, 3, 9, 7, 2, 5, 10] order might differ
