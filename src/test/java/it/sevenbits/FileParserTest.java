package it.sevenbits;

import it.sevenbits.exceptions.ParserException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FileParserTest {
    @Test
    public void fewWordTest() throws ParserException {
      FileParser fewWord = new FileParser();
        assertArrayEquals(new String[]{"two", "words"}, fewWord.parse(" ", "src/test/java/resources/FewWords.txt"));
    }
    @Test
    public void oneWordTest() throws ParserException {
        FileParser oneWord = new FileParser();
        assertArrayEquals(new String[]{"one"}, oneWord.parse(" ", "src/test/java/resources/OneWord.txt"));
    }


    @Test(expected = ParserException.class)
    public void sourceNullTest() throws ParserException {
        FileParser sourceNull = new FileParser();
        sourceNull.parse(" ", "src/test/java/resources/EmptyFile.txt");
    }

}
