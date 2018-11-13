package it.sevenbits;

import it.sevenbits.exceptions.ParserException;

/**
 * class StringParser
 */
public class StringParser implements IParser {
    /**
     *
     * @param delimiter delimiter
     * @param source source
     * @return array
     * @throws ParserException exception
     */
    public String[] parse(final String delimiter, final String source) throws  ParserException {
        if (source.length() == 0) {
            throw new ParserException("\n" +
                    "empty");
        }
        int number = 0;
        int j = 0;
        int word = 0;
        for (int i = 1; i < source.length(); i++) {
            if (source.charAt(i) == delimiter.charAt(0)) {
                number++;
            }
        }
        String[] array = new String[number + 1];
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == delimiter.charAt(0)) {
                array[word] = source.substring(j, i);
                j = i + 1;
                word++;
            }
        }
        array[word] = source.substring(j);
        return array;
    }
}

