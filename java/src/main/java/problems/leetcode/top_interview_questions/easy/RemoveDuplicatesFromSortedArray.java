package problems.leetcode.top_interview_questions.easy;

/**
 * IMPORTANT
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
