package com.github.cbserra.codewars.kyu4;

import com.github.cbserra.codewars.kyu6.MorseCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class MorseCodeDecoder {
    private static final String WORD_DELIMITER = "\\s{3}";
    private static final String LETTER_DELIMITER = "\\s";

    private static final String DOT_BITS = "[1]{2}";
    private static final String DASH_BITS = "[1]{6}";
    private static final String CODE_DELIMITER_BITS = "[0]{2}";
    private static final String LETTER_DELIMITER_BITS = "[0]{6}";
    private static final String WORD_DELIMITER_BITS = "[0]{14}";
    private static final String DASH = "-";
    private static final String DOT = ".";
    public static final String SPACE = "\\s";
    private static final String CODE_DELIMITER_MORSE = "";
    private static final String LETTER_DELIMITER_MORSE = " ";
    private static final String WORD_DELIMITER_MORSE = "   ";

//    public static String decodeBits(String bits) {
//        String validBits = bits.substring(bits.indexOf("1"), bits.lastIndexOf("1") + 1);
//        System.out.println("bits = " + bits);
//        System.out.println("validBits = " + validBits);
//
//        List<String> wordBits = stream(validBits.split(WORD_DELIMITER_BITS))
//                .collect(toList());
//        System.out.println("wordBits = " + wordBits);
//
//        List<List<String>> letterBits = wordBits
//                .stream()
//                .map(l -> stream(l.split(LETTER_DELIMITER_BITS))
//                .collect(toList()))
//                .collect(toList());
//        System.out.println("letterBits = " + letterBits);
//
//        List<String> codeBits = new ArrayList<>();
//        for (List<String> letters : letterBits) {
//            System.out.println("letters = " + letters);
//            List<String> replacedBits = letters.stream().map(c -> c.replaceAll(DASH_BITS, DASH).replaceAll(DOT_BITS, DOT).replaceAll(CODE_DELIMITER_BITS, SPACE)).collect(toList());
//            System.out.println("replacedBits = " + replacedBits);
//
//            List<String> morse = new ArrayList<>();
//            for (String replacedBit : replacedBits) {
//                List<String> replacedCodeBits = stream(replacedBit.split(CODE_DELIMITER_BITS)).collect(toList());
//                morse.addAll(replacedCodeBits);
//                System.out.println("morse = " + morse);
//                System.out.println("replacedCodeBits = " + replacedCodeBits);
//                codeBits.addAll(morse);
//            }
//        }
//
//        System.out.println("codeBits = " + codeBits);
//
////        List<List<List<String>>> codeBits = new ArrayList<>(letterBits);
////        codeBits.stream()
////                .map(c -> c.split(CODE_DELIMITER_BITS))
//////                .map(List::stream)
////
////
////                .collect(toList());
////
////        System.out.println("letterBits = " + letterBits);
//
//        return ".";
//    }

//    public static String decodeBits(String bits) {
//        String validBits = bits.substring(bits.indexOf("1"), bits.lastIndexOf("1") + 1);
//        System.out.println("bits = " + bits);
//        System.out.println("validBits = " + validBits);
//
//        int rate = getRate(validBits);
//
//        String replacedZeroes = validBits
////                .replaceAll("[0]{" + rate + "}", DASH)
////                .replaceAll("[0]{" + 2* rate +"}", DOT)
//                .replaceAll("[0]{" + 7 * rate + "}", WORD_DELIMITER_MORSE)
//                .replaceAll("[0]{" + 3 * rate + "}", LETTER_DELIMITER_MORSE)
//                .replaceAll("[0]{" + 2 * rate + "}", CODE_DELIMITER_MORSE);
//
//        int dotLength = Pattern.compile("0").matcher(replacedZeroes).groupCount();
////        String validMorsecode = replacedZeroes.replaceAll()
//
//        System.out.println("validMorseCode = " + replacedZeroes);
//
//        return replacedZeroes;
//    }
//
//    public static String decodeMorse(String morseCode) {
//        List<String> decodedWords = new ArrayList<>();
//        stream(morseCode.trim().split(WORD_DELIMITER))
//                .collect(toList())
//                .stream()
//                .map(s -> asList(s.split(LETTER_DELIMITER)))
//                .collect(toList())
//                .forEach(innerList -> {
//                    String decodedWord = innerList
//                            .stream()
//                            .map(MorseCode::get)
//                            .collect(joining());
//                    decodedWords.add(decodedWord);
//                });
//
//        return String.join(SPACE, decodedWords);
//    }


        public static String decodeBits(String bits) {
            String trimmedBits = bits.replaceAll("^0+|0+$", "");
            int rate = getRate(trimmedBits);
            System.out.println("rate = " + rate);

            StringBuilder morseCodeBuilder = new StringBuilder();
            String morseCode = "";
            for (String word : trimmedBits.split("0{"+ (7 * rate) +"}")) {
                for (String letter : word.split("0{"+ (3 * rate) +"}")) {
                    for (String dot : letter.split("0{" + rate + "}")) {
                        System.out.println("dot = " + dot);
                        char dotOrDash = dot.length() > rate ? '-' : '.';
                        System.out.println("dotOrDash = " + dotOrDash);
                        morseCodeBuilder.append(dotOrDash);
                    }
                    morseCodeBuilder.append(" ");
                }
                morseCodeBuilder.append("   ");
            }
            System.out.println("morseCodeBuilder.toString().trim() = '" + morseCodeBuilder.toString().trim() + "'");
            return morseCodeBuilder.toString().trim();
        }

        private static int getRate(String bits) {
            int rate = Integer.MAX_VALUE;
            Matcher matcher = Pattern.compile("1+|0+").matcher(bits);
            while (matcher.find()) {
                rate = Math.min(rate, matcher.group().length());
                System.out.println("rate = " + rate);

            }
            return rate;
        }

        public static String decodeMorse(String morseCode) {
            System.out.println("morseCode = '" + morseCode + "'");

            StringBuilder decoded = new StringBuilder();
            for (String word : morseCode.trim().split(WORD_DELIMITER)) {
                for (String letter : word.trim().split(LETTER_DELIMITER)) {
                    System.out.println("letter = '" + letter + "'");
                    decoded.append(MorseCode.get(letter));
                }
                decoded.append(' ');
            }
//            return String.join(decoded, " ");
//            decoded.
            System.out.println("decoded.toString().trim() = '" + decoded.toString().trim() + "'");

            return decoded.toString().trim();
        }

}