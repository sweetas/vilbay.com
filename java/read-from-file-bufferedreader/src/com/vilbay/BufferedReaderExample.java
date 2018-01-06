package com.vilbay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class BufferedReaderExample {

    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        URL path = BufferedReaderExample.class.getResource(FILE_NAME);

        try {

            fileReader = new FileReader(new File(path.getFile()));
            bufferedReader = new BufferedReader(fileReader);

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();

            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }
}
