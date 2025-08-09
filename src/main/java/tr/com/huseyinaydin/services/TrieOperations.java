package tr.com.huseyinaydin.services;

import java.util.TreeSet;

public interface TrieOperations {
    void insert(String word);
    TreeSet<String> getWordsWithPrefix(String prefix);
}