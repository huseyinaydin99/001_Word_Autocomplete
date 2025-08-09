package tr.com.huseyinaydin.services;

import java.io.IOException;
import java.util.List;
import tr.com.huseyinaydin.services.impl.TrieService;

public class DictionaryService {

    private final TrieService trieService = new TrieService();

    public DictionaryService(DictionaryLoader loader) throws IOException {
        List<String> words = loader.loadWords();
        for (String word : words) {
            trieService.insert(word);
        }
    }

    public List<String> searchByPrefix(String prefix) {
        return trieService.getWordsWithPrefix(prefix);
    }
}
