package problems.leetcode.top_interview_questions.easy;

import java.util.Arrays;

public class CompareStringsByFrequencyOfSmallestChar {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqs= new int[11];
        for(int i=0; i<words.length; i++) freqs[findMinCharacterFrequency(words[i])-1]++;
        for(int i=8; i>=0; i--) freqs[i]+= freqs[i+1];
        int[] response= new int[queries.length];
        for(int i=0; i<queries.length; i++) response[i]= freqs[findMinCharacterFrequency(queries[i])];
        return response;
    }


    public int findMinCharacterFrequency(String s){
        char c= s.charAt(0), min= c;
        for(int i=1; i<s.length(); i++) if ((c= s.charAt(i))<min) min= c;
        int freq= 0;
        for(int i=0; i<s.length(); i++) if (min==s.charAt(i)) freq++;
        return freq;
    }


    public static void main(String[] args) {

        String[] queries=new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[] words = new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};

        System.out.println(Arrays.toString(new CompareStringsByFrequencyOfSmallestChar()
                .numSmallerByFrequency(queries, words)));
    }

}
