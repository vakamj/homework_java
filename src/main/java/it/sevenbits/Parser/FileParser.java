package it.sevenbits.Parser;

import it.sevenbits.exceptions.ParserException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * class FileParser
 */
public class FileParser implements IParser {
    /**
     * @param delimiter delimiter
     * @param source    source
     * @return array
     * @throws ParserException exception
     */
    public String[] parse(final String delimiter, final String source) throws ParserException {

        String[] array;
        try (BufferedReader file = new BufferedReader(new FileReader(source))) {
            String line;
            StringBuilder sb = new StringBuilder();
            StringParser stringParser = new StringParser();
            while ((line = file.readLine()) != null) {
                sb.append(line).append(delimiter);
            }

           array = stringParser.parse(delimiter, sb.toString().trim());
        } catch (IOException e) {
            System.out.println("Can’t read the file");
            throw new ParserException(e);
        }
        return array;
    }
}
