package com.github.cbserra.codewars.kyu6;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class MorseCodeDecoder {
    private static final String WORD_DELIMITER = "\\s{3}";
    private static final String LETTER_DELIMITER = "\\s";
    public static final String SINGLE_SPACE = " ";

    public static String decode(String morseCode) {
        return stream(morseCode.trim().split(WORD_DELIMITER))
                .map(outer -> stream(outer.split(LETTER_DELIMITER))
                .map(MorseCode::get)
                .collect(joining()))
                .collect(joining(SINGLE_SPACE));
    }
}