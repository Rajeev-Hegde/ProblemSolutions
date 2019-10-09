package problems.leetcode.top_interview_questions.medium;

/**
 * IMPORTANT
 A peak element is an element that is greater than its neighbors.

 Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that nums[-1] = nums[n] = -∞.


 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    public int findPeakElement(int[] nums, int left, int right){

        while(left< right){
            int mid1= (left+right)/2;
            int mid2 = mid1+1;
            if (nums[mid1] < nums[mid2]) {
                left = mid2;
            } else {
                right = mid1;
            }
        }
        return left;
    }
}
