package problems.leetcode.top_interview_questions.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * IMPORTANT
 */
public class AllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null){
            return Collections.emptyList();
        }
        int length=nums.length;
        for (int i=0;i<length;i++) {
            while (nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<length;i++) {
            if(nums[i]!=i+1){
                list.add(i+1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
