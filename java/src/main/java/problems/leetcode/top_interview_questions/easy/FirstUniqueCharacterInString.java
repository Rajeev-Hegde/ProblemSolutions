package problems.leetcode.top_interview_questions.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        char[] charArr = s.toCharArray();
        for(char ch:charArr) {
            freqMap.putIfAbsent(ch, 0);
            freqMap.put(ch, freqMap.get(ch)+1);
        }
        int i=0;
        for(char ch: charArr){
            if(freqMap.get(ch)==1)
                return i;
            i++;
        }
        return -1;
    }


}
