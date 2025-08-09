package tr.com.huseyinaydin.services;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<String> readLines() throws IOException;
}