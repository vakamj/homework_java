package it.sevenbits;

import it.sevenbits.exceptions.ParserException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringParserTest {
    @Test
    public void oneWordTest() throws ParserException {
        StringParser oneWord = new StringParser();
        assertArrayEquals(new String[]{"one"}, oneWord.parse(" ", "one"));
    }

    @Test
    public void fewWordTest() throws ParserException {
        StringParser fewWord = new StringParser();
        assertArrayEquals(new String[]{"two", "words"}, fewWord.parse(" ", "two words"));
    }

    @Test(expected = ParserException.class)
    public void sourceNullTest() throws ParserException {
        StringParser sourceNull = new StringParser();
        sourceNull.parse(" ", "");
    }
}
