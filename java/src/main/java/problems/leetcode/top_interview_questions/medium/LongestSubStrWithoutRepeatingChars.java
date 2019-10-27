package problems.leetcode.top_interview_questions.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {

    public int lengthOfLongestSubstringSlow(String s) {
        int maxLen = 0;
        for(int i=0; i< s.length(); i++){
            int temp=i;
            if(s.length()-i< maxLen) break;
            Set<Character> charSet = new HashSet<>();
            while(temp< s.length() && !charSet.contains(s.charAt(temp))){
                charSet.add(s.charAt(temp));
                temp++;
            }
            maxLen = Math.max(maxLen, charSet.size());
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new LongestSubStrWithoutRepeatingChars().lengthOfLongestSubstring("bbtablud"));
    }
}
