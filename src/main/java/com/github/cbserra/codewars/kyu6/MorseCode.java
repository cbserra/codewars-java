package com.github.cbserra.codewars.kyu6;

import java.util.Map;

import static java.util.Map.entry;

/**
 * Thanks to Eric Wang {@link https://www.codewars.com/users/kuchaguangjie} for providing this implementation of com.github.cbserra.codewars.kyu4.MorseCode, ena
 */
public class MorseCode {

    public static String get(String code) {
        return MORSE_MAP.get(code);
    }

    private static final Map<String, String> MORSE_MAP = Map.ofEntries(
            entry("-.-.-.", ";"),
            entry("-...-", "="),
            entry("---", "O"),
            entry("----.", "9"),
            entry("-..-.", "/"),
            entry(".-...", "&"),
            entry("...--", "3"),
            entry(".--", "W"),
            entry("--", "M"),
            entry("--..", "Z"),
            entry(".----.", "'"),
            entry("-.-.--", "!"),
            entry("-...", "B"),
            entry("..-", "U"),
            entry(".----", "1"),
            entry("-.--.-", ")"),
            entry(".-", "A"),
            entry("-....-", "-"),
            entry("...-", "V"),
            entry("...---...", "SOS"),
            entry("-.--", "Y"),
            entry("..", "I"),
            entry("--.-", "Q"),
            entry("-.", "N"),
            entry("..---", "2"),
            entry("-....", "6"),
            entry("---...", ";"),
            entry(".-.-.", "+"),
            entry(".--.-.", "@"),
            entry("....-", "4"),
            entry("-----", "0"),
            entry(".-.-.-", "."),
            entry("-.-.", "C"),
            entry(".", "E"),
            entry("..-.", "F"),
            entry(".---", "J"),
            entry("-.-", "K"),
            entry(".-..", "L"),
            entry(".-.", "R"),
            entry("...", "S"),
            entry("--.", "G"),
            entry("---..", "8"),
            entry("..--..", "?"),
            entry("-.--.", "("),
            entry(".--.", "P"),
            entry(".....", "5"),
            entry("..--.-", "_"),
            entry("-..", "D"),
            entry(".-..-.", "\""),
            entry("-", "T"),
            entry("....", "H"),
            entry("--..--", ","),
            entry("...-..-", "$"),
            entry("--...", "7"),
            entry("-..-", "X")
    );
}