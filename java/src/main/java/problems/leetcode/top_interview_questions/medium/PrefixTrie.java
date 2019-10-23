package problems.leetcode.top_interview_questions.medium;

public class PrefixTrie {

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
    public PrefixTrie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode iterator = root;
        for(char ch: word.toCharArray()){
            int pos = ch - 'a';
            if(iterator.children[pos]== null)
                iterator.children[pos]= new TrieNode();
            iterator= iterator.children[pos];
        }
        iterator.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode iterator = root;
        for(char ch: word.toCharArray()){
            int pos = ch-'a';
            if(iterator.children[pos]== null)
                return false;
            iterator = iterator.children[pos];
        }
        return iterator!= null && iterator.isEndOfWord;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode iterator = root;
        for(char ch: prefix.toCharArray()){
            int pos = ch-'a';
            if(iterator.children[pos]== null)
                return false;
            iterator = iterator.children[pos];
        }
        return true;
    }


    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}
