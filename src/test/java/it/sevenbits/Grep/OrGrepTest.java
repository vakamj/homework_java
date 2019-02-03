package it.sevenbits.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OrGrepTest {
    /**
     * test to verify the output of lines that contain at least one of a set of words
     *
     * @throws IOException empty file
     */
    @Test
    public void doOrGrep() throws IOException {
        GrepFactory grepFactory = new GrepFactory();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("seven Two");
        expectedList.add("five eight");
        List<String> grepList = new ArrayList<>();
        grepList.add("seven");
        grepList.add("eight");
        OrGrep orGrep = grepFactory.getOrGrep(grepList);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("Файл пустой");
            }
            List<String> actualList = orGrep.doGrep(reader);
            Assert.assertEquals(expectedList, actualList);
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
        grepList.add("one");
        OrGrep orGrep = grepFactory.getOrGrep(grepList);
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
        grepList.add("one");
        OrGrep orGrep = grepFactory.getOrGrep(grepList);
        File file = new File("src/test/java/resources/textGrep.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (!reader.ready()) {
                throw new IOException("empty file");
            }

        }
    }
}