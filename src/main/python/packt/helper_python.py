from pyspark.sql import SparkSession


def create_session(num_threads: int=2, name: str="Spark Application") -> SparkSession:
    session: SparkSession = SparkSession.builder \
        .master('local[{}]'.format(num_threads)) \
        .appName(name) \
        .getOrCreate()
    return session # // program simulates a single executor with numThreads cores (one local JVM with numThreads threads)