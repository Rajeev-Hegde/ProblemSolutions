package problems.leetcode.top_interview_questions.hard;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class MissingPositiveNumber {

    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int currentMin=nums[0], currentPos=0;

        for(int i=1; i< nums.length; i++){
            if((nums[i] & currentMin) < currentMin)
                currentPos=i;
            currentMin=nums[i] & currentMin;
        }
        return currentPos;
    }
}
