package problems.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

//TODO: Fix this problem
public class ReplaceSubsStringForBalancedString {

    public int balancedString(String s) {
        int total=0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for(char ch: s.toCharArray()){
            charFrequency.merge(ch, 1, (a,b)-> a+b);
        }

        for(Map.Entry<Character, Integer> entry: charFrequency.entrySet()){
            if(entry.getValue()> s.length()/4)
                total+=entry.getValue()-s.length()/4;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSubsStringForBalancedString().balancedString( "WWEQERQWQWWRWWERQWEQ"));
    }
}
