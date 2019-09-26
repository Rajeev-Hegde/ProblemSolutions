package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getPermutations(nums,res,new ArrayList<>(),new ArrayList<>());
        return res;
    }

    public void getPermutations(int[] nums,List<List<Integer>> res, List<Integer> current, List<Integer> coveredIndexes){
        if(current.size() == nums.length){
            res.add(current);
        }
        for(int i = 0; i<nums.length; i++){
            if(!coveredIndexes.contains(i)){
                List<Integer> temp = new ArrayList<>(current);
                temp.add(nums[i]);
                List<Integer> tempCoveredIndices = new ArrayList<>(coveredIndexes);
                tempCoveredIndices.add(i);
                getPermutations(nums,res,temp, tempCoveredIndices);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
