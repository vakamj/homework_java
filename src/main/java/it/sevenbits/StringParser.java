package it.sevenbits;

import it.sevenbits.exceptions.ParserException;

/**
 * class StringParser
 */
public class StringParser implements IParser {
    /**
     * @param delimiter delimiter
     * @param source    source
     * @return array
     * @throws ParserException exception
     */
    public String[] parse(final String delimiter, final String source) throws ParserException {
        if (source == null) {
            throw new ParserException("\n" +
                    "null");
        }
        if (source.length() == 0) {
            throw new ParserException("\n" +
                    "empty");
        }

        int delimitersAmount = 0;
        int j = 0;
        int wordCount = 0;
        boolean delimsMet = true;

        for (int i = 1; i < source.length(); i++) {
            if ((source.charAt(i) == delimiter.charAt(0)) && (delimsMet)) {
                delimsMet = false;
                delimitersAmount++;
            }
            if ((source.charAt(i) != delimiter.charAt(0)) && (!delimsMet)) {
                delimsMet = true;
            }
        }
        String[] array = new String[delimitersAmount + 1];
        for (int i = 0; i < source.length(); i++) {
            if ((source.charAt(i) == delimiter.charAt(0)) && (delimsMet)) {
                delimsMet = false;
                array[wordCount] = source.substring(j, i);
                j = i + 1;
                wordCount++;
            }
            if ((source.charAt(i) != delimiter.charAt(0)) && (!delimsMet)) {
                j = i;
                delimsMet = true;
            }
        }
        array[wordCount] = source.substring(j);
        return array;
    }
}

