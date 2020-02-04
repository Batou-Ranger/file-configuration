package com.theghostshell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Optional;

public class PropertiesReader {
    private Reader         fileReader;
    private BufferedReader bufferedReader;
    private int            maxLine;

    /**
     * @param path
     * @param maxLine
     * @throws FileNotFoundException
     */
    public PropertiesReader(String path, Integer maxLine) throws FileNotFoundException {
        fileReader      = new FileReader(path);
        bufferedReader  = new BufferedReader(fileReader);

        this.maxLine    = Optional.ofNullable(maxLine)
            .map(integer -> this.maxLine = maxLine)
            .orElse(100);
    }

    public PropertiesCollection read() throws IOException {
        HashMap<String, String> props = new HashMap<>();
        String                  line;
        int                     limit = 0;

        while ((line = bufferedReader.readLine()) != null && limit <= maxLine) {
            String[] prop = line.split("=");

            props.put(prop[0], prop[1]);

            limit++;
        }

        close();
        return new PropertiesCollection(props);
    }

    private void close() throws IOException {
        fileReader.close();
    }
}
