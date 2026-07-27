package Neetcode.DataStructuresAndAlgorithms.trie;

public class TrieDataStructure {
    TrieNode root;

    public TrieDataStructure(){
        root = new TrieNode();
    }

    void main() {
        TrieDataStructure trieDataStructure = new TrieDataStructure();
        trieDataStructure.insert(root,"apple");
        trieDataStructure.insert(root,"ape");
        System.out.println(trieDataStructure.search(root,"apple"));
        System.out.println(trieDataStructure.startsWith(root,"app"));
    }

    public void insert(TrieNode root,String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(TrieNode root,String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(TrieNode root,String prefix){
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
