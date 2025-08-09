package tr.com.huseyinaydin.services;

import java.util.List;

public interface DictionaryService {
    List<String> searchByPrefix(String prefix);
}