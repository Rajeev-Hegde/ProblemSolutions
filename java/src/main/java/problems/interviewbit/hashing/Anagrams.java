package problems.interviewbit.hashing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {


    boolean isAnagram(String s1, String s2){
        Map<Character,Integer> charRepeat = new HashMap<>();
        if(s1.length()!=s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if(!charRepeat.containsKey(s1.charAt(i)))
                charRepeat.put(s1.charAt(i), 0);
            charRepeat.merge(s1.charAt(i),1,(a,b)-> a+b);

            if(!charRepeat.containsKey(s2.charAt(i)))
                charRepeat.put(s2.charAt(i), 0);
            charRepeat.merge(s2.charAt(i),1,(a,b)-> a-b);
        }

        for(Map.Entry<Character,Integer> entry: charRepeat.entrySet()){
            if(entry.getValue()!=0)
                return false;
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Set<String> completedWords = new HashSet<>();
        Map<String,ArrayList<Integer>> anagramGroups = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if(completedWords.contains(A.get(i)))
                continue;
            anagramGroups.put(A.get(i), new ArrayList<>(Arrays.asList(i+1)));
            for (int j = i+1; j < A.size(); j++) {
                final boolean anagram = isAnagram(A.get(i), A.get(j));
                if(anagram){
                    completedWords.add(A.get(j));
                    int finalJ = j;
                    anagramGroups.computeIfPresent(A.get(i), (val1, val2)->{

                        val2.add(finalJ+1);
                    return val2;
                    });
                }

            }
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        System.out.println(new Anagrams().anagrams(new ArrayList<>(Arrays.asList("cat", "dog", "god" , "tca"))));
    }
}
