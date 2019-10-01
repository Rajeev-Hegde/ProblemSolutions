package problems.leetcode.top_interview_questions.easy;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int num: nums){
            if(currentSum+num < num)
                currentSum=num;
            else
                currentSum+=num;
            if(maxSum< currentSum)
                maxSum=currentSum;
        }
        return maxSum;
    }
}
