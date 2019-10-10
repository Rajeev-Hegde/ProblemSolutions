package problems.leetcode.top_interview_questions.easy;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            while(nums[i]!=nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }


        for(int i=0; i< nums.length; i++){
            if(nums[i]!=i+1) res.add(nums[i]);
        }
        return res;
    }


    public void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]= temp;
    }
}
