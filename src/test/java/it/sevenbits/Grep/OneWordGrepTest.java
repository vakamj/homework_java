package it.sevenbits.Grep;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OneWordGrepTest {
    /**
     * test to check the output of lines that contain word
     *
     * @throws IOException empty file
     */
    @Test
    public void doOneWordGrep() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("words");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("one of a set of words");
        expectedList.add("all words from a set of words");
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
            List<String> actualList = oneWordGrep.doGrep(reader);
            assertTrue(expectedList.containsAll(actualList));
        }
    }

    /**
     * test to verify the output of lines that contain a word using a factory
     *
     * @throws IOException empty file
     */
    @Test
    public void doOneWordGrepFactory() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep("words");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("one of a set of words");
        expectedList.add("all words from a set of words");
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
            List<String> actualList = oneWordGrep.doGrep(reader);
            assertTrue(expectedList.containsAll(actualList));
        }
    }

    /**
     * test for checking empty grep-word
     *
     * @throws IOException empty file
     */
    @Test(expected = IOException.class)
    public void doEmptyGrep() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep("");
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
        }
    }

    /**
     * test for checking null grep-word
     *
     * @throws IOException  empty file
     */
    @Test(expected = IOException.class)
    public void doNullGrep() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep(null);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
        }
    }
}
