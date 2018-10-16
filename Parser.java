package it_sevenbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser<array> {
    public static String[] parse(final String strInput) {
        char[] x = strInput.toCharArray();
        int y = 0;
        int n = 0;
        for (int i = 1; i < strInput.length(); i++) {
            if (x[i] == ' ')
                y++;
        }
        String[] array = new String[y+1];
        for (String str : strInput.split(" ")) {
            array[n] = str;
            n++;
        }
        return array;
    }
    public static void main (String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Parser class1 = new Parser();
        String[] s = class1.parse(reader.readLine());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}