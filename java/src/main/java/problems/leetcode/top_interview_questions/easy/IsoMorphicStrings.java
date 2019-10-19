package problems.leetcode.top_interview_questions.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsoMorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> completedCharacterSet = new HashSet<>();
        int i=0;
        while(i< s.length()){
            if((!mapping.containsKey(s.charAt(i)) && completedCharacterSet.contains(t.charAt(i))) ||
                    mapping.containsKey(s.charAt(i)) && mapping.get(s.charAt(i)) != t.charAt(i))
                return false;
            mapping.putIfAbsent(s.charAt(i), t.charAt(i));
            completedCharacterSet.add(t.charAt(i));
            i++;
        }

        return true;
    }


    public boolean isIsomorphicFasterSoln(String sString, String tString) {

        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsoMorphicStrings().isIsomorphic("ab", "aa"));
    }
}
