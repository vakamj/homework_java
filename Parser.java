package it_sevenbits;

public class Parser {
    public static String[] parse(final String strInput) {
        int number = 0;
        int j = 0;
        int u = 0;
        for (int i = 1; i < strInput.length(); i++) {
            if (strInput.charAt(i) == ' ')
                number++;
        }
        String[] array = new String[number + 1];
        for (int i = 0; i < strInput.length(); i++) {
            if (strInput.charAt(i) == ' ') {
                array[u] = strInput.substring(j, i);
                j = i + 1;
                u++;
            }

        }
        array[u] = strInput.substring(j);
        return array;
    }
}