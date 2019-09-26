package problems.leetcode.top_interview_questions.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        if(s.length()!=t.length())
            return false;
        for(int i=0; i< s.length(); i++){
            frequencyMap.merge(s.charAt(i), 1, (a,b)-> a+b );
            frequencyMap.putIfAbsent(t.charAt(i),0);
            frequencyMap.merge(t.charAt(i), 1, (a,b)-> a-b );
        }
        System.out.println(frequencyMap);
        for(Integer value: frequencyMap.values()){
            if(value!=0)
                return false;
        };
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("anagram",
                "nagaram"));
    }
}
