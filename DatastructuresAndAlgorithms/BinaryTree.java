package DatastructuresAndAlgorithms;

/*
'''
Given the base class and the stub of the two instantiating classes, implement the abstract methods.
You can imagine this class as a tree with the letters at the leaves.
eg:

                  <Word>
                /        \
            <Word>        <Word>
             /  \        /     \
         "as"    "pca"  <Word>   "mouse"
                      /
                   "mic"



Code examples:

Word word = new WordInternalNode(WordInternalNode(WordLeafNode("as"), WordLeafNode("pca")), WordInternalNode(WordInternalNode(WordLeafNode("mic"), WordLeafNode("key")), WordLeafNode("mouse")));
word.length(); # 16
word.char_at(1); # s
word.char_at(4); # a
word.substring(3,9); # "camick"
word.to_string(); # "aspcamickeymouse"
'''
 */

import java.io.*;
import java.util.*;

interface Word {
    int length();
    String char_at(int i);
    String subString(int start, int stop);
    String toString();
}


class WordInternalNode implements Word {
    Word left;
    Word right;
    int length;

    public WordInternalNode(Word left, Word right) {
        this.left = left;
        this.right = right;
        this.length = (left != null ? left.length() : 0) + (right != null ? right.length() : 0);
    }

    public int length(){
        return length;
    }

    public String char_at(int i){
        int leftStringLength = left != null ? left.length() : 0;
        if(i < leftStringLength){
            if(left != null){
                return left.char_at(i);
            }else{
                System.out.println("Left node is null");
            }
        }else{
            if(right != null){
                return right.char_at(i - left.length());
            }
            else{
                System.out.println("Left node is null");
            }
        }
        return "";
    }

    public String subString(int start,int stop){
        int leftStringLength = left != null ? left.length() : 0;
        if(stop <= leftStringLength){
            if(left != null){
                return left.subString(start, stop);
            }else{
                return "";
            }
        }else if(start >= left.length()){
            if(right != null){
                return right.subString(start - left.length(), stop - left.length());
            }else{
                return "";
            }
        }else{
            String leftString = left != null ? left.subString(start, left.length()) : "";
            String rightString = right != null ? right.subString(0, stop - left.length()) : "";
            return leftString + rightString;
        }
    }

    public String toString(){
        String leftString = left != null ? left.toString() : "";
        String rightString = right != null ? right.toString() : "";
        return leftString + rightString;
    }


}

class WordLeafNode implements Word {
    String cstr;


    public WordLeafNode(String cstr) {
        this.cstr = cstr;
    }

    public int length(){
        return cstr.length();
    }

    public String char_at(int i){
        return String.valueOf(cstr.charAt(i));
    }

    public String subString(int start,int stop){
        return cstr.substring(start, stop);
    }

    public String toString(){
        return cstr;
    }

}

class Solution{
    public static void main(String[] args) {
        Word word = new WordInternalNode(new WordInternalNode
                (new WordLeafNode("as"), new WordLeafNode("pca"))
                ,new WordInternalNode(new WordInternalNode(new WordLeafNode("mic")
                ,new WordLeafNode("key"))
                ,new WordLeafNode("mouse")));

        System.out.println(word.length());
        System.out.println(word.char_at(1));
        System.out.println(word.subString(3,9));
        System.out.println(word);

    }
}



