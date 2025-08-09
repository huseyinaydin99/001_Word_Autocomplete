package tr.com.huseyinaydin.services;

import java.util.List;

public interface TrieOperations {
    void insert(String word);
    List<String> getWordsWithPrefix(String prefix);
}