package it_sevenbits;

public class Parser<array> {
    public static String[] parse(final String strInput) {
        char[] array1 = strInput.toCharArray();
        int number_of_spaces = 0;
        int dimension = 0;
        for (int i = 1; i < strInput.length(); i++) {
            if (array1[i] == ' ')
                number_of_spaces++;
        }
        String[] array = new String[number_of_spaces+1];
        for (String str : strInput.split(" ")) {
            array[dimension] = str;
            dimension++;
        }
        return array;
    }
}