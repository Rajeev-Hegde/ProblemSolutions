package problems.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrances {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num: arr){
            frequencyMap.merge(num, 1, (a,b)-> a+b);
        }
        return frequencyMap.values().size()== new HashSet<>(new ArrayList<>(frequencyMap.values())).size();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueNumberOfOccurrances().uniqueOccurrences(new int[]{1,2,3,3,3,2}));
    }
}
