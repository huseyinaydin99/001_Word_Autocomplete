package tr.com.huseyinaydin.services;

import java.util.TreeSet;

public interface DictionaryService {
    TreeSet<String> searchByPrefix(String prefix);
}