package it.sevenbits.Grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * class OrGrep to filter the text, the output will show those lines that contain at least one word
 */
public class OrGrep implements IGrep {
    private List<String> list;

    /**
     * @param list filter list
     * @throws IOException if filter list is empty or does not exist
     */
    public OrGrep(final List<String> list) throws IOException {
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
     * @return lines that contain at least one word from the list
     * @throws IOException
     */
    @Override
    public List doGrep(final Reader reader) throws IOException {
        List<String> stringList = new ArrayList();
        try (BufferedReader br = new BufferedReader(reader)) {
            StringBuilder sb = new StringBuilder();
            String delimiter = "/n";
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(delimiter);

            }
            String[] arrayString = sb.toString().split(delimiter);
            for (String aList : list) {
                for (int i = 0; i < arrayString.length; i++) {
                    if (arrayString[i].contains(aList)) {
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
