package tr.com.huseyinaydin.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import tr.com.huseyinaydin.model.TrieNode;
import tr.com.huseyinaydin.services.TrieOperations;

public class TrieServiceImpl implements TrieOperations {

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public TreeSet<String> getWordsWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TreeSet<String> treeSetResults = new TreeSet<>();
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            node = node.getChildren().get(ch);
            if (node == null) {
                return treeSetResults; // Prefix yoksa boş liste
            }
        }
        collectWords(node, new StringBuilder(prefix), treeSetResults);
        return treeSetResults;
    }

    private void collectWords(TrieNode node, StringBuilder prefix, TreeSet<String> results) {
        if (node.isEndOfWord()) {
            results.add(prefix.toString()); //TreeSet add metodu eğer veri ambarında aynı veriden varsa tekrar eklemez. Böylelikle tekrarlanma sorunu çözülür her bir girdi benzersizdir!
        }
        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            prefix.append(entry.getKey());
            collectWords(entry.getValue(), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}