package com.github.cbserra.codewars.kyu6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MorseCodeDecoderTest {

    @Test
    public void testExampleFromDescription() {
        assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }

    @Test
    public void testBasicMorseDecoding() {
        assertThat(MorseCodeDecoder.decode(".-"), is("A"));
        assertThat(MorseCodeDecoder.decode("."), is("E"));
        assertThat(MorseCodeDecoder.decode(".."), is("I"));
        assertThat(MorseCodeDecoder.decode(". ."), is("EE"));
        assertThat(MorseCodeDecoder.decode(".   ."), is("E E"));
        assertThat(MorseCodeDecoder.decode("...---..."), is("SOS"));
        assertThat(MorseCodeDecoder.decode("... --- ..."), is("SOS"));
        assertThat(MorseCodeDecoder.decode("...   ---   ..."), is("S O S"));
    }

    @Test
    public void testMoreComplexTests() {
        assertThat(MorseCodeDecoder.decode(" . "), is("E"));
        assertThat(MorseCodeDecoder.decode("   .   . "), is("E E"));
        assertThat(MorseCodeDecoder.decode("      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  "), is("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG."));
    }
}