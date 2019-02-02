package it.sevenbits.Grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * class OneWordGrep to filter the text, the output will show those lines that contain the word
 */
public class OneWordGrep implements IGrep {
    private String wordGrep;

    /**
     * @param wordGrep filter word
     * @throws IOException if filter word is empty or does not exist
     */
    public OneWordGrep(final String wordGrep) throws IOException {

        if (wordGrep == null) {
            throw new IOException("null");
        }
        if (wordGrep.length() == 0) {
            throw new IOException("empty");
        }
        this.wordGrep = wordGrep;
    }

    /**
     * @param reader stream reader for filtering
     * @return lines that contain the grep-word
     * @throws IOException
     */
    public List doGrep(Reader reader) throws IOException {
        List list = new ArrayList();
        try (BufferedReader br = new BufferedReader(reader)) {
            StringBuilder sb = new StringBuilder();
            String delimiter = "/n";
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(delimiter);
            }
            String[] arrayString = sb.toString().split(delimiter);
            for (int i = 0; i < arrayString.length; i++) {
                if (arrayString[i].contains(wordGrep)) {
                    list.add(arrayString[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("file is empty");
        }
        return list;
    }

}

