package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //Simple recursive approach
    public List<List<Integer>> permuteUsingSimpleRecursive(int[] nums) {
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

    //Recursive +swap approach
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            list.add(nums[pos]);
            backtrack(lists, list, nums, pos + 1);
            swap(nums, pos, i);
            list.remove(list.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
