package Neetcode.neetcode150.trie;

import Neetcode.DataStructuresAndAlgorithms.trie.TrieNode;

import java.util.*;

public class WordSearch2 {
    TrieNodeWord root;

    void main() {
        WordSearch2 wordSearch2 = new WordSearch2();
        char[][] c = {
        {'a','b','c','d'},
        {'s','a','a','t'},
        {'a','c','k','e'},
        {'a','c','d','n'}};
        String[] words = {"bat","cat","back","backend","stack"};
        System.out.println(wordSearch2.findWords(c,words));
    }

    public WordSearch2(){
        root = new TrieNodeWord();
    }
//    public List<String> findWords(char[][] board, String[] words) {
//        Set<String> res = new HashSet<>();
//        for (String word : words) {
//            for (int row = 0; row < board.length; row++) {
//                for (int col = 0; col < board[0].length; col++) {
//                    if (board[row][col] == word.charAt(0)) {
//                        dfs(row, col, 0, board, word, res);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }

//    private void dfs(int row,int col,int j,char[][] board,String word,Set<String> res){
//        if(row == board.length || col == board[0].length || Math.min(row,col) < 0 || board[row][col] == '1'){
//            return;
//        }
//        if(word.charAt(j) != board[row][col]){
//            return;
//        }
//        if(j == word.length() - 1){
//            res.add(word);
//            return;
//        }
//
//        char temp = board[row][col];
//        board[row][col] = '1';
//        dfs(row + 1,col,j + 1,board,word,res);
//        dfs(row - 1,col,j + 1,board,word,res);
//        dfs(row,col + 1,j + 1,board,word,res);
//        dfs(row,col - 1,j + 1,board,word,res);
//        board[row][col] = temp;
//    }

    public void insert(TrieNodeWord root,String word){
        TrieNodeWord curr = root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNodeWord());
            }
            curr = curr.children.get(c);
        }
        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            insert(root, word);
        }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    dfs(row, col, board, res,root);
                }
            }
        return res;
    }


    private void dfs(int row,int col,char[][] board,List<String> res,TrieNodeWord root) {
        if (row == board.length || col == board[0].length || Math.min(row, col) < 0 || board[row][col] == '#') {
            return;
        }

        char c = board[row][col];

        if (!root.children.containsKey(c)) {
            return;
        }
        TrieNodeWord nextNode = root.children.get(c);
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[row][col] = '#';

        dfs(row + 1, col, board, res,nextNode);
        dfs(row - 1, col, board, res,nextNode);
        dfs(row, col + 1, board, res,nextNode);
        dfs(row, col - 1, board, res,nextNode);
        board[row][col] = c;
    }
}
class TrieNodeWord{
    HashMap<Character,TrieNodeWord> children;
    String word = null;

    public TrieNodeWord(){
        children = new HashMap<>();
    }
}
