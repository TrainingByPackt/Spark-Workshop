package packt.spark
import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.test.SharedSQLContext

class TestIntersect extends SparkFunSuite with SharedSQLContext {

  val words1 = List[String]("Settlements", "some", "centuries", "old", "and", "still", "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background")
  val words2 = List[String]("centuries", "old", "and", "still", "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of")

  test("intersect") {
    val wordsRdd1 = spark.sparkContext.parallelize(words1)
    val wordsRdd2 = spark.sparkContext.parallelize(words2)
    val intersection = wordsRdd1.intersection(wordsRdd2, 1)
    assert(intersection.count() == words1.size-4)

  }
}
