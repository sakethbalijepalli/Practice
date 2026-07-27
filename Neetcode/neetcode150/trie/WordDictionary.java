package Neetcode.neetcode150.trie;

import Neetcode.DataStructuresAndAlgorithms.trie.TrieNode;
public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    void main() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("dog");
//        wordDictionary.addWord("bay");
//        wordDictionary.addWord("may");
//        System.out.println(wordDictionary.search("say"));
//        System.out.println(wordDictionary.search("day"));
        System.out.println(wordDictionary.search("do.."));
        System.out.println(wordDictionary.search(".ay"));
        System.out.println(wordDictionary.search("b.."));

    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }

        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.word;
    }
}