package it.sevenbits.Parser;

import it.sevenbits.exceptions.ParserException;

/**
 * interface IParser
 */
public interface IParser {
    /**
     * @param delimiter delimiter
     * @param source    source
     * @return words from source
     * @throws ParserException exceptions
     */
    String[] parse(String delimiter, String source) throws ParserException;
}
