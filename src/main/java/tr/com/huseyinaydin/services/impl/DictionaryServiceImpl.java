package tr.com.huseyinaydin.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;
import tr.com.huseyinaydin.services.DictionaryLoader;
import tr.com.huseyinaydin.services.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {

    private final TrieServiceImpl trieService = new TrieServiceImpl();

    public DictionaryServiceImpl(DictionaryLoader loader) throws IOException {
        List<String> words = loader.loadWords();
        for (String word : words) {
            trieService.insert(word.toLowerCase());
        }
    }

    public TreeSet<String> searchByPrefix(String prefix) {
        return trieService.getWordsWithPrefix(prefix.toLowerCase(/*Locale.forLanguageTag("TR")*/));
    }
}