package problems.leetcode.top_interview_questions.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * IMPORTANT
 */
public class ShortestWordDistance {

    List<Integer> findWordPos(String[] words, String word ){
        List<Integer> pos=  new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word))
                pos.add(i);
        }
        return pos;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> word1Loc = findWordPos(words, word1);
        List<Integer> word2Loc = findWordPos(words, word2);
        int diff = Integer.MAX_VALUE;
        int i=0, j=0;

        while(i< word1Loc.size() && j< word2Loc.size()){
            if(Math.abs(word1Loc.get(i)- word2Loc.get(j))< diff)
                diff= Math.abs(word1Loc.get(i)- word2Loc.get(j));
            if(word1Loc.get(i)< word2Loc.get(j))
                i++;
            else
                j++;
        }
        return diff;
    }


    public int shortestDistanceEfficient(String[] words, String word1, String word2){
        int i1 = -1, i2 = -1, ans = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) i1 = i;
            if(words[i].equals(word2)) i2 = i;
            if(i1 != -1 && i2 != -1)
                ans = Math.min(ans, Math.abs(i1-i2));
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println( new ShortestWordDistance()
                .shortestDistance(new String[]{"a","c","b","a"},
                "a","b"));

        System.out.println( new ShortestWordDistance()
                .shortestDistanceEfficient(new String[]{"a","c","b","a"},
                        "a","b"));
    }
}
