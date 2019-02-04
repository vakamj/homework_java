package it.sevenbits.Grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * class AndGrep, to filter the text in the output will display lines that contain all the words though
 */
public class AndGrep implements IGrep {
    private List<String> list;

    /**
     * @param list filter list
     * @throws IOException if filter list is empty or does not exist
     */
    public AndGrep(final List<String> list) throws IOException {
        for (String aList : list) {
            if (aList == null) {
                throw new IOException("null");
            }
        }
        for (String aList : list) {
            if (aList.length() == 0) {
                throw new IOException("empty");
            }
        }
        this.list = list;

    }

    /**
     * @param reader stream reader for filtering
     * @return lines that contain all the grep-words
     * @throws IOException
     */
    @Override
    public List doGrep(final Reader reader) throws IOException {
        List<String> stringList = new ArrayList();
        try (BufferedReader br = new BufferedReader(reader)) {
            String delimiter = "/n";
            String line;
            boolean stringContainsWord = true;

            while ((line = br.readLine()) != null) {
                String[] arrayString = line.split(delimiter);
                for (int i = 0; i < arrayString.length; i++) {
                    for (String aList : list) {
                        if (!arrayString[i].contains(aList)) {
                            stringContainsWord = false;
                        }
                    }
                    if (stringContainsWord) {
                        stringList.add(arrayString[i]);
                    }
                    stringContainsWord = true;
                }
            }

        } catch (IOException e) {
            System.out.println("file is empty");
        }
        return stringList;
    }
}
