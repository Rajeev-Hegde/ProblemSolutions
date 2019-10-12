package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

    private Map<String,List<Integer>> wordLoc = new HashMap<>();
    public ShortestWordDistance(String[] words) {
        for(int i=0; i<words.length; i++){
            wordLoc.putIfAbsent(words[i], new ArrayList<>());
            wordLoc.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if(!wordLoc.containsKey(word1) || !wordLoc.containsKey(word2))
            return -1;
        else{
            List<Integer> list1 = wordLoc.get(word1);
            List<Integer> list2 = wordLoc.get(word2);
            return getMinDiff(list1, list2);
        }
    }

    // for the function that finds the minimum distance between the two words, the complexity would be O(max(K,L))
    // where K and L representthe number of occurrences of the two words.
    public int getMinDiff(List<Integer> list1, List<Integer> list2){
        int i=0, j=0, min=Integer.MAX_VALUE;
        while(i< list1.size() && j< list2.size()){
            if(Math.abs(list1.get(i)-list2.get(j))<  min)
                min= Math.abs(list1.get(i)-list2.get(j));
            else{
                if(list1.get(i)< list2.get(j)){
                    i++;
                }
                else
                    j++;
            }

        }
        return min;
    }
}
