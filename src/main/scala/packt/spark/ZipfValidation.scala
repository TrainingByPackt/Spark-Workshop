package packt.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import packt.HelperScala

object ZipfValidation {

  def main(args: Array[String]): Unit = {
    val session: SparkSession = HelperScala.createSession(2, "Zipf Validation")
    val lines: RDD[String] = session.sparkContext.textFile(HelperScala.novellaLocation)

    val countsPerToken: RDD[(String, Int)] = lines
      .flatMap(_.toLowerCase.split("\\s+")) // split on whitespace
      .map(word => (word.replaceAll("(^[^a-z0-9]+|[^a-z0-9]+$)", ""), 1)) // removing punctuation
      .reduceByKey((count1, count2) => count1 + count2, 2)

    val sortedCountsToken = countsPerToken.map(_.swap) // swap is equivalent to `pair =>(pair._2, pair._1)`
      .sortByKey(false)

    sortedCountsToken.saveAsTextFile("./sortedcounts")
  }

}
