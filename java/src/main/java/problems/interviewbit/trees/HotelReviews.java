package problems.interviewbit.trees;

import java.util.*;
import java.util.stream.Collectors;

public class HotelReviews {

    static class Trie {

        // Alphabet size (# of symbols)
        static final int ALPHABET_SIZE = 26;

        // trie node
        static class TrieNode
        {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];

            // isEndOfWord is true if the node represents
            // end of a word
            boolean isEndOfWord;

            TrieNode(){
                isEndOfWord = false;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        };

        TrieNode root =new TrieNode();

        // If not present, inserts key into trie
        // If the key is prefix of trie node,
        // just marks leaf node
        void insert(String key)
        {
            int level;
            int length = key.length();
            int index;

            TrieNode pCrawl = root;

            for (level = 0; level < length; level++)
            {
                index = key.charAt(level) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
            }

            // mark last node as leaf
            pCrawl.isEndOfWord = true;
        }

        // Returns true if key presents in trie, else false
        boolean search(String key)
        {
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++)
            {
                index = key.charAt(level) - 'a';

                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }

            return (pCrawl != null && pCrawl.isEndOfWord);
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Trie trie = new Trie();
        for (String goodnessWord : A.split("_")) {
            trie.insert(goodnessWord);
        }
        Map<Integer,Integer> goodnessCount = new HashMap<>();
        int i=0;
        for (String review: B){
            goodnessCount.putIfAbsent(i,0);
            String[] reviewWords= review.split("_");
            for (String reviewWord: reviewWords) {
                if (trie.search(reviewWord)){
                    goodnessCount.merge(i,1, (a,b)-> a+b);
                }
            }

            i++;
        }

        final Map<Integer, Integer> sortedByCount = goodnessCount.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return  new ArrayList<>(sortedByCount.keySet());
    }

    public static void main(String[] args) {
        new HotelReviews().solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")));
    }
}
