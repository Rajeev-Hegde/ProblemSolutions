package problems.leetcode.top_interview_questions.easy;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    public String getHint(String secret, String guess) {

        int bullCount=0;
        int cowCount=0;
        Map<Character,Integer> secretNumMap = new HashMap<>();
        Map<Character,Integer> guessNumMap = new HashMap<>();
        for(int i=0; i< secret.length(); i++){
            if(guess.charAt(i) == secret.charAt(i))
                bullCount++;
            else{
                guessNumMap.merge(guess.charAt(i),1, (a, b)-> a+b );
                secretNumMap.merge(secret.charAt(i), 1, (a,b)-> a+b);
            }
        }

        for(Map.Entry<Character, Integer> entry :guessNumMap.entrySet()){
            if(secretNumMap.containsKey(entry.getKey())){
                cowCount+= Math.min(secretNumMap.get(entry.getKey()), entry.getValue());
            }
        }
        return bullCount+"A"+ cowCount+"B";
    }


}
