package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubSequence {

    public int numMatchingSubseq(String S, String[] words) {
        int res=0;
        Map<String,Boolean> resMap= new HashMap<>();
        for(String word: words){
            if(resMap.containsKey(word)){
                if(resMap.get(word))
                    res++;
            }
            else{
                resMap.put(word,isSubsequence(word,S));
                if(resMap.get(word)){
                    res++;
                }
            }
        }

        return res;
    }


    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i< s.length() && j< t.length()){
            if(s.charAt(i)== t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public int numMatchingSubseqEfficient(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

}

class Node {
    String word;
    int index;
    public Node(String w, int i) {
        word = w;
        index = i;
    }
}