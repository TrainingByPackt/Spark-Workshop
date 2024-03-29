package packt.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import packt.HelperScala;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Code for performing word count in Spark (Java)
 *
 * @author Phil, https://github.com/g1thubhub
 */
public class WordCountSpark {

    public static void main(String... args) {

        SparkSession session = HelperScala.createSession(2, "Java WordCount RDD");

        // Preprocessing & reducing the input lines:
        JavaRDD<String> lines = session.read().textFile(HelperScala.novellaLocation()).javaRDD();
        JavaRDD<String> words = lines.flatMap(text -> Arrays.asList(text.split("\\s+")).iterator());
        JavaPairRDD<String, Integer> tokenFrequ = words.mapToPair(word -> new Tuple2<>(word.toLowerCase(), 1));
        JavaPairRDD<String, Integer> counts = tokenFrequ.reduceByKey((a, b) -> a + b);

        // Materializing to local disk:
        counts.coalesce(2) // optional, without coalesce many tiny output files are generated
                .saveAsTextFile("./countsplits");

        session.stop();
    }
}