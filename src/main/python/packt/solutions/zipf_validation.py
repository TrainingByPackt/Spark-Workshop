from pyspark.rdd import RDD
from pyspark.sql import SparkSession
from packt.helper_python import create_session, novella_location
from operator import add
import re

if __name__ == "__main__":
    session: SparkSession = create_session(2, "Zipf validation")
    lines: RDD = session.sparkContext.textFile(novella_location)

    counts_per_token = lines \
        .flatMap(lambda line: line.lower().split()) \
        .map(lambda word: (re.sub(r"(^[^a-z0-9]+|[^a-z0-9]+$)", '', word), 1)) \
        .reduceByKey(add)

    sorted_counts = counts_per_token.map(lambda tuple: (tuple[1], tuple[0])) \
        .sortByKey(ascending=False)

    sorted_counts.saveAsTextFile("./sortedcounts")