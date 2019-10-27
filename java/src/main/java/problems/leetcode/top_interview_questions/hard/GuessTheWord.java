package problems.leetcode.top_interview_questions.hard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GuessTheWord {

    static class Master{

        private String secret;
        Master(String secret){
            this.secret = secret;
        }

        public int guess(String word){
            int total=0;
            for(int i=0; i< word.length(); i++){
                if(word.charAt(i)== this.secret.charAt(i))
                    total++;
            }
            return  total;
        }
    }

    public boolean findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) {
            return false;
        }

        int n = wordlist.length;
        int l = wordlist[0].length();
        int[][] f = new int[n][n];

        Set<Integer> possible = new HashSet<>();
        for (int i = 0; i < n; i++) {
            possible.add(i);
        }
        while (!possible.isEmpty()) {
            // pick the first word in the set brainlessly
            Iterator<Integer> iterator = possible.iterator();
            int choice = iterator.next();

            int matches = master.guess(wordlist[choice]);
            if (matches == l) { // we found the match!
                return true;
            }
            Set<Integer> possible2 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                // This is the key!
                // Candidates are among the words that have the same number of matches with the guessed word as the returned matches
                // And candidates must be among the list (set) of candidates remained from previous guesses
                if (countMatches(wordlist[choice], wordlist[i]) == matches && possible.contains(i)) {
                    possible2.add(i);
                }
            }
            possible = possible2;
        }
        return false;
    }

    private int countMatches(String word1, String word2) {
        int l = word1.length();
        int matches = 0;
        for (int k = 0; k < l; k++) {
            if (word1.charAt(k) == word2.charAt(k)) {
                matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {

        System.out.println(new GuessTheWord()
                .findSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"},new Master("acckzz")));
    }
}
