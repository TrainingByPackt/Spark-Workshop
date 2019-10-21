package packt.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalBasicsJ {

    public static void main(String... args) {

        List<String> words = new ArrayList<>(Arrays.asList("Settlements", "some", "centuries", "old", "and", "still",
                "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background"));

        List<Integer> lengths = words.stream().map(word -> word.length()).collect(Collectors.toList()); // lambda
        List<Integer> lengths2 = words.stream().map(String::length).collect(Collectors.toList()); // using method reference


        List<String> oWords = words.stream().filter(word -> word.startsWith("o")).collect(Collectors.toList());
        System.out.println(oWords);
    }

}
// Result: [old, on, of]