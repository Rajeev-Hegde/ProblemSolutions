package problems.leetcode.top_interview_questions.medium;

import java.util.*;

public class WordBreak {


    /**
     * Simple solution without recursion/DP approach
     * @param s
     * @param wordDict
     * @return
     */
    /*public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> pos = new ArrayList<>();
        pos.add(0);
        wordDict.sort(Comparator.comparingInt(String::length));
        while(!pos.isEmpty()){
            int i= pos.get(0);
            if(pos.get(pos.size()-1)== s.length())
                return true;
            pos.remove(0);
            if(s.length()-i <  wordDict.get(0).length())
                return false;

            for(String word:wordDict){
                if(s.length()-i <  word.length())
                    break;
                if (s.substring(i).startsWith(word) && !pos.contains(i+word.length()))
                    pos.add(i+word.length());
            }
        }
        return false;
    }*/

    /**
     * Using DP
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> dict = new HashSet();
        for (String word : wordDict)
        {
            dict.add(word);
        }

        boolean[] f = new boolean[s.length() + 1];
        f[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i)
        {
            for (int j = i; j < s.length(); ++j)
            {
                String prefix = s.substring(i, j + 1);
                if (f[j + 1] && dict.contains(prefix))
                {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[0];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak()
                .wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        Arrays.asList("a","aa","aaa","aaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
