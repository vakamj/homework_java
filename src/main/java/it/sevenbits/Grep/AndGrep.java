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
            StringBuilder sb = new StringBuilder();
            String delimiter = "/n";
            String line;
            boolean stringContainsWord;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(delimiter);
            }
            String[] arrayString = sb.toString().split(delimiter);
            for (String aList : list) {
                for (int i = 0; i < arrayString.length; i++) {
                    if (!arrayString[i].contains(aList)) {
                        stringContainsWord = false;
                        break;
                    }
                    if (stringContainsWord = true) {
                        stringList.add(arrayString[i]);
                    }
                }
            }


        } catch (IOException e) {
            System.out.println("file is empty");
        }
        return stringList;
    }
}
