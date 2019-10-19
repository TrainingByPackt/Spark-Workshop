package packt.spark;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import packt.HelperScala;
import java.util.*;

public class MapClosureJava {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Settlements", "some", "centuries", "old", "and", "still",  "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background"));
        SparkSession session = HelperScala.createSession(2, "Java map closure");
        JavaSparkContext jcontext = new JavaSparkContext(session.sparkContext());
        JavaRDD<String> wordsRdd =  jcontext.parallelize(words);

        JavaRDD<Integer> wordLengths = wordsRdd.map(word -> word.length()); // passing a closure to Spark's `map`
        System.out.println(wordLengths.collect()); // printing result to stdout
        // Result: [11, 4, 9, 3, 3, 5, 2, 6, 4, 8, 2, 3, 9, 7, 2, 5, 10] order might differ
    }
}
