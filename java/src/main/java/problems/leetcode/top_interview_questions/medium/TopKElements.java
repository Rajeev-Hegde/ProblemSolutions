package problems.leetcode.top_interview_questions.medium;

import java.util.*;
import java.util.stream.Collectors;

public class TopKElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(Integer num: nums){
            frequency.merge(num, 1, (a,b)-> a+b);
        }

        List<Map.Entry<Integer,Integer>> entryList= new ArrayList<>(frequency.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        if(entryList.size()< k)
            return entryList.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        else{
            return entryList.subList(0,k).stream().map(Map.Entry::getKey).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        int a =2147483647;
        System.out.println( new TopKElements().topKFrequent(new int[]{1,2,2,1,1,3,3,3}, 6));
    }
}
