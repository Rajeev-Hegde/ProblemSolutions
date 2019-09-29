package problems.leetcode.top_interview_questions.easy;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarSentence {


    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length!=words2.length)
            return false;
        Map<String,Set<Integer>> wordLocation = new HashMap<>();
        for(int i=0; i<pairs.size(); i++){
            List<String> pair = pairs.get(i);
            if(pair.size()!=0){
                for(String word: pair)
                    wordLocation.computeIfAbsent(word,k -> new HashSet<>()).add(i);
            }
        }
        for(int i=0; i< words1.length; i++){
            int finalI = i;
            if(words1[i].equals(words2[i]))
                continue;

            if(wordLocation.containsKey(words1[i]) &&
                    wordLocation.containsKey(words2[i]) &&
                    wordLocation.get(words1[i]).stream()
                    .filter(num-> wordLocation.get(words2[finalI]).contains(num))
                    .collect(Collectors.toList()).size()> 0)
                continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great","fine"));
        pairs.add(Arrays.asList("drama","acting"));
        pairs.add(Arrays.asList("skills","talent"));
        System.out.println(new SimilarSentence().areSentencesSimilar(
                new String[]{"great","acting","skills"},
                new String[]{"fine","painting","talent"},
                pairs
        ));
    }
}
