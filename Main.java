package it_sevenbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser class1 = new Parser();
        String[] s = class1.parse(reader.readLine());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
