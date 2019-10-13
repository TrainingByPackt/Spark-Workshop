package packt.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalBasicsJ {

    public static void main(String... args) {

        List<String> tokens = new ArrayList<>(Arrays.asList("Settlements", "some", "centuries", "old", "and", "still",
                "no", "bigger", "than", "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background"));

        List<Integer> lengths = tokens.stream().map(token -> token.length()).collect(Collectors.toList()); // lambda
        List<Integer> lengths2 = tokens.stream().map(String::length).collect(Collectors.toList()); // using method reference
        System.out.println(lengths);
        System.out.println(lengths2);
    }

}
