package problems.leetcode.top_interview_questions.medium;

/**
 * IMPORTANT
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {

    TrieNode root;
    static class TrieNode{
        boolean isEndOfWord=false;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){
            for(int i=0; i< 26; i++){
                children[i]= null;
            }
        }
    }


    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode iterator = root;
        for(char ch: word.toCharArray()){
            int pos = ch - 'a';
            if(iterator.children[pos]== null)
                iterator.children[pos]= new TrieNode();
            iterator= iterator.children[pos];
        }
        iterator.isEndOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, this.root,0);
    }
    public boolean search(String word, TrieNode iterator, int wordPointer) {
        if(wordPointer== word.length() && iterator!=null && iterator.isEndOfWord)
            return true;
        else if(wordPointer< word.length() && iterator!=null){
            char ch=word.charAt(wordPointer);
            if(ch!='.') {
                int charPos = ch - 'a';
                return iterator.children[charPos] != null && search(word, iterator.children[charPos], wordPointer + 1);
            }
            else{
                for(int i=0; i< 26; i++){
                    boolean searchRes=search(word,iterator.children[i], wordPointer+1);
                    if(searchRes)
                        return true;
                }
            }
        }
        return false;
    }
}
