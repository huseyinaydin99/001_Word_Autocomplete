package tr.com.huseyinaydin.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tr.com.huseyinaydin.model.TrieNode;

public class TrieService {

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public List<String> getWordsWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            node = node.getChildren().get(ch);
            if (node == null) {
                return results; // Prefix yoksa boş liste
            }
        }
        collectWords(node, new StringBuilder(prefix), results);
        return results;
    }

    private void collectWords(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord()) {
            results.add(prefix.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            prefix.append(entry.getKey());
            collectWords(entry.getValue(), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}