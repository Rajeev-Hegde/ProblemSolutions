package problems.leetcode.top_interview_questions.easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maxRepeatedNum=nums[0];
        int count=0;

        for(int num: nums){
            if(num== maxRepeatedNum){
                count++;
            }
            else{
                if(count<= 0){
                    maxRepeatedNum = num;
                    count=1;
                }
                else
                    count--;
            }
        }
        return maxRepeatedNum;
    }
}
