package com.vilbay;

import java.io.*;

public class Main {

    public static final String UTF8_BOM = "\uFEFF";


    public static void main(String[] args) throws IOException {


        InputStreamReader inputStreamReader;
        inputStreamReader = new InputStreamReader(Main.class.getResourceAsStream("example.txt"), "UTF8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        boolean firstLine = true;

        for (String line = ""; (line = bufferedReader.readLine()) != null;) {
            if (firstLine) {
                line = Main.removeUTF8BOM(line);
                firstLine = false;

            }

            System.out.println(line);
        }

        bufferedReader.close();
    }

    private static String removeUTF8BOM(String string) {
        if (string.startsWith(UTF8_BOM)) {
            string = string.substring(1);
        }
        return string;
    }
}
