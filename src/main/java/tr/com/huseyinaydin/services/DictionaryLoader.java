package tr.com.huseyinaydin.services;

import java.io.IOException;
import java.util.List;

public interface DictionaryLoader {
    List<String> loadWords() throws IOException;
}