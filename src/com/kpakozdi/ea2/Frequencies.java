package com.kpakozdi.ea2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequencies {
    public static void main(String[] args) {


        String s = "ebben a szövegben kétszer szerepel az ebben szó és még háromszor az az";
        Map<String, Integer> frequencies = getFrequencies(s);
        Map<String, Long> frequenciesFP = getFrequenciesFP(s);

        System.out.println(frequencies);
        System.out.println(frequenciesFP);
    }

    public static Map<String, Long> getFrequenciesFP(String s) {
        String[] words = s.split(" ");
        return Arrays.stream(words)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
    }

    public static Map<String, Integer> getFrequencies(String s) {
        Map<String, Integer> freq = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (freq.containsKey(word)) {
                Integer previousFreq = freq.get(word);
                freq.put(word, previousFreq + 1);
            } else {
                freq.put(word, 1);
            }
        }
        return freq;
    }
}
