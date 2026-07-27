package Neetcode.DataStructuresAndAlgorithms.trie;

import java.util.HashMap;

public class TrieNode {

    public HashMap<Character,TrieNode> children;
    public boolean word;

    public TrieNode(){
        children = new HashMap<>();
        word = false;
    }
}
