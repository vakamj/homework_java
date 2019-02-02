package it.sevenbits.Grep;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class GrepFactory {
    /**
     * @param wordGrep filter word
     * @return lines that contain the grep-word
     * @throws IOException if filter word is empty or does not exist
     */
    public OneWordGrep getOneWordGrep(final String wordGrep) throws IOException {
        return new OneWordGrep(wordGrep);
    }

    /**
     * @param list filter list
     * @return lines that contain at least one word from the list
     * @throws IOException if filter word is empty or does not exist
     */
    public OrGrep getOrGrep(final List<String> list) throws IOException {
        return new OrGrep(list);
    }

    /**
     * @param list filter list
     * @return lines that contain all the grep-words
     * @throws IOException if filter word is empty or does not exist
     */
    public AndGrep getAndGrep(final List<String> list) throws IOException {
        return new AndGrep(list);
    }
}
