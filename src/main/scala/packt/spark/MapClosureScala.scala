package packt.spark

import org.apache.spark.sql.SparkSession
import packt.HelperScala

object MapClosureScala {
  def main(args: Array[String]): Unit = {
    val tokens = List[String]("Settlements", "some", "centuries", "old", "and", "still", "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background")
    val session: SparkSession = HelperScala.createSession(2, "Scala map closure")
    val tokensRdd = session.sparkContext.parallelize(tokens)

    val tokenLengths = tokensRdd.map(token => token.length) // passing a closure to Spark's `map`
    println(tokenLengths.collect().toList) // printing result to stdout
    // Result: List(11, 4, 9, 3, 3, 5, 2, 6, 4, 8, 2, 3, 9, 7, 2, 5, 10) order might differ

  }
}
