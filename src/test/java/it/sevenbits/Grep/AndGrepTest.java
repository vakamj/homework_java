package it.sevenbits.Grep;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AndGrepTest {

    @Test
    public void doAndGrep() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("one wordkk");
        expectedList.add("one of a set of words");
        List<String> grepList = new ArrayList<>();
        grepList.add("one wordkk");
        grepList.add("one of a set of words");
        AndGrep andGrep = new AndGrep(grepList);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
            List<String> actualList = andGrep.doGrep(reader);
            assertTrue(expectedList.containsAll(actualList));
        }
    }

    /**
     * test to check at least one empty grep word from the list
     *
     * @throws IOException empty file
     */
    @Test(expected = IOException.class)
    public void doEmptyGrep() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        List<String> grepList = new ArrayList<>();
        grepList.add("");
        grepList.add("exit");
        AndGrep andGrep = grepFactory.getAndGrep(grepList);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }
        }
    }

    /**
     * test to check at least one null grep word from the list
     *
     * @throws IOException empty file
     */
    @Test(expected = IOException.class)
    public void doNullGrep() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        List<String> grepList = new ArrayList<>();
        grepList.add(null);
        grepList.add("exit");
        AndGrep andGrep = grepFactory.getAndGrep(grepList);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }

        }
    }

}