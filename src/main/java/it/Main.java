package it;


import it.sevenbits.Grep.GrepFactory;
import it.sevenbits.Grep.IGrep;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
     * @param args standard input arguments
     */
    public static void main(final String[] args) throws IOException {
        // -s "one two three" -one three
        // -f "src/test/java/resources/textGrep.txt" -one three

        final int sourceGrep = 0;
        final int stringGrep = 1;
        final int typeGrep = 2;
        final int delimiterFilter = 3;
        final int typeDelimiter = 4;
        if ((args.length < 4) || (args[sourceGrep].isEmpty()) || (args[stringGrep].isEmpty()) ||(args[typeGrep].isEmpty())
                || (args[delimiterFilter].isEmpty())) {
            throw new IOException("Oops, something went wrong");
        }

        String delimiter = " ";
        if (args.length == 4) {
            delimiter = args[typeDelimiter];
        }
        GrepFactory grepFactory = new GrepFactory();
        List<String> grepList = new ArrayList<>();
        Collections.addAll(grepList, args[delimiterFilter].split(delimiter));
        List<String> list;
        IGrep grep;
        Reader reader;
        if (args[sourceGrep].equals("-f")) {
            reader = new BufferedReader(new java.io.FileReader(new File(args[stringGrep])));

        } else {
            if (args[sourceGrep].equals("-s")) {
                reader = new StringReader(args[stringGrep]);

            } else {
                throw new IOException("wrong source");
            }
        }
        if (args[typeGrep].equals("-and")) {
            grep = grepFactory.getAndGrep(grepList);
        } else {
            if (args[typeGrep].equals("-or")) {
                grep = grepFactory.getOrGrep(grepList);
            } else {

                if (args[typeGrep].equals("-one")) {
                    grep = grepFactory.getOneWordGrep(args[delimiterFilter]);
                } else {
                    throw new IOException("wrong typeGrep");
                }
            }
        }
        list = grep.doGrep(reader);
        reader.close();
        System.out.println(list.toString());
    }
}

