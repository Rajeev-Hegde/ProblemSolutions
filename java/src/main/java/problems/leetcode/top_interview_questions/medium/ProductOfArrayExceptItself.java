package problems.leetcode.top_interview_questions.medium;


import java.util.Arrays;

/**
 * INTERESTING_QUESTION
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]


 Below solution: time complexity=> O(1), space complexity => O(1)
 */
public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0]= 1;
        for(int i=1; i< nums.length; i++){
            res[i]= res[i-1]* nums[i-1];
        }

        int right = 1;
        for(int i=nums.length-1; i>=0 ; i--){
            res[i] = res[i]*right;
            right*=nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptItself().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
