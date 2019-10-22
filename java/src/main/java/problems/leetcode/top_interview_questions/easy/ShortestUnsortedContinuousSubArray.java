package problems.leetcode.top_interview_questions.easy;

public class ShortestUnsortedContinuousSubArray {

    public int findUnsortedSubarray(int[] nums) {
        int i=0 , j= nums.length-1;
        if(nums.length==1) return 0;
        while(i+1< nums.length && nums[i]<= nums[i+1]){
            if(nums[i]== nums[i+1]){
                int k=i;
                while(k+1< nums.length && nums[k]== nums[k+1])
                    k++;
                if(k+1< nums.length && nums[k]> nums[k+1])
                    break;
                else
                    i=k;
            }
            i++;
        }

        while(j-1>i && nums[j]>= nums[i] && nums[j]>= nums[j-1]) {
            if(nums[j]== nums[j-1]){
                int k=j;
                while(k-1< nums.length && nums[k]== nums[k-1])
                    k--;
                if(k-1< nums.length && nums[k-1]> nums[k])
                    break;
                else
                    j=k;
            }
            j--;
        }
        return i==j? 0: j-i+1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubArray().findUnsortedSubarray(new int[]{1,2,4,5,3}));
    }
}
