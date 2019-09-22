package problems.leetcode.medium;

import java.util.*;

public class WordBreak2 {

    /**
     * Working solution but results in TLE if there is time constraint check is added.
     */
    /*public void getSentence(String s, List<String> wordDict,Set<String> completedSentences,String res){

        if(s.isEmpty())
            completedSentences.add(res);
        else
            for(int i=0; i< s.length(); i++){
                String word = s.substring(0, i+1);
                String temp = res;
                if(wordDict.contains(word)){
                    temp+= (!temp.isEmpty()?" ":"") +word;
                    getSentence(s.substring(i+1),wordDict,completedSentences,temp);
                }
            }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> sentences = new HashSet<>();
        getSentence(s,wordDict,sentences,"");
        return new ArrayList<>(sentences);
    }*/

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        Map<String, List<String>> memo = new HashMap<>();
        return helper(set, s, memo);
    }
    public List<String> helper(Set<String> set, String s, Map<String, List<String>> memo){
        List<String> list = new ArrayList<>();
        if(s.length() == 0) return list;
        if(memo.containsKey(s)) return memo.get(s);

        if(set.contains(s)){
            list.add(s);
        }

        for(int i = 1; i <= s.length(); i++){
            String str = s.substring(0, i);
            if(!set.contains(str)) continue;
            List<String> candidates = helper(set, s.substring(i), memo);
            for(String next : candidates){
                list.add(str + " " + next);
            }
        }

        memo.put(s, list);
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(new WordBreak2().wordBreak("catsanddog",
//                Arrays.asList("cat", "cats", "and", "sand", "dog")));
        //System.out.println(new WordBreak2().wordBreak("pineapplepenapple",
        //        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new WordBreak2().wordBreak("aaaaaaaaaaaaaa",
                        Arrays.asList("aaaa","aaa")));
//        System.out.println( new WordBreak2().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                        "aaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        //[aaa aaaa aaa aaaa, aaaa aaa aaa aaaa, aaaa aaa aaaa aaa, aaaa aaaa aaa aaa, aaa aaaa aaaa aaa, aaa aaa aaaa aaaa]
        //[aaa aaaa aaa aaaa, aaaa aaa aaa aaaa, aaaa aaa aaaa aaa, aaaa aaaa aaa aaa, aaa aaaa aaaa aaa]
    }
}
