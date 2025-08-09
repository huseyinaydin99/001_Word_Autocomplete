package tr.com.huseyinaydin.services.impl;

import tr.com.huseyinaydin.services.FileReaderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tr.com.huseyinaydin.services.FileReaderService;

public class DictionaryFileReader implements FileReaderService {

    private final String fileName;

    public DictionaryFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}