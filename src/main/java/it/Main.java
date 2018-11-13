package it;

import it.sevenbits.FileParser;
import it.sevenbits.IParser;
import it.sevenbits.StringParser;
import it.sevenbits.exceptions.ParserException;
import java.util.Arrays;

/**
 * main
 */
public final class Main {
    /**
     * constructor main
     */
    private Main() {
    }
    /**
     * displays words in line
     *
     * @param args standard input arguments
     */
    public static void main(final String [] args) {

        IParser textParser = new StringParser();
        IParser fileParser = new FileParser();
        try {
            System.out.println(Arrays.toString(textParser.parse(" ", "Here are four words")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(textParser.parse("/", "And/here/are/five/words")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(fileParser.parse(" ", "src/main/resources/FewLines.txt")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(fileParser.parse(" ", "src/main/resources/FewWords.txt")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(fileParser.parse(" ", "src/main/resources/OneWord.txt")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(fileParser.parse(" ", "src/main/resources/EmptyFile.txt")));
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
    }
}