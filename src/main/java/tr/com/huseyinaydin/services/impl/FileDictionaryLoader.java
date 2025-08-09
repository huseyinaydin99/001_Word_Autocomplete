package tr.com.huseyinaydin.services.impl;

import tr.com.huseyinaydin.services.DictionaryLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileDictionaryLoader implements DictionaryLoader {

    private final String fileName;

    public FileDictionaryLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> loadWords() throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }
}