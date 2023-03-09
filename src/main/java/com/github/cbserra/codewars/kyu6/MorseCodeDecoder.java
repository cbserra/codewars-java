package com.github.cbserra.codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class MorseCodeDecoder {
    private static final String WORD_SEP = "\\s{3}";
    private static final String LETTER_SEP = "\\s";

//    public static String decode(String morseCode) {
//        List<String> morseWords = List.of(morseCode.trim().split("\\s{3}"));
//
//        List<String> decodedWords = new ArrayList<>();
//        for (String morseWord : morseWords) {
//            String decodedWord = Stream.of(morseWord.split("\\s"))
//                    .map(MorseCode::get)
//                    .collect(Collectors.joining());
//            decodedWords.add(decodedWord);
//        }
//
//        return String.join(" ", decodedWords);
//    }

    public static String decode(String morseCode) {
//        List<String> decodedWords = new ArrayList<>();
        return stream(morseCode.trim().split(WORD_SEP))
                .map(outer -> stream(outer.split(LETTER_SEP))
                .map(MorseCode::get).collect(Collectors.joining())
                .
//                .collect(Collectors.toList())
                .forEach(innerList -> {
                    String decodedWord = innerList
                            .stream()
                            .map(MorseCode::get)
                            .collect(Collectors.joining());
                    decodedWords.add(decodedWord);
                });

        return String.join(" ", decodedWords);
    }
}