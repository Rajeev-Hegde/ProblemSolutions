package problems.leetcode.top_interview_questions.medium;

public class LongestIncreasingSubSequence {

    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        dp = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            int currentMax= helper(nums, i+1, 1, nums[i]);
            dp[i]= currentMax;
            maxLen=Math.max(maxLen, currentMax);
        }
        return maxLen;
    }

    public int helper(int[]nums, int j, int subLen, int currentMin){
        if(j== nums.length)
            return subLen;
        int len;
        if(nums[j]> currentMin){
            if(dp[j]!=0) {
                len= subLen+ dp[j];
            }
            else {
                len = helper(nums, j + 1, subLen + 1, nums[j]);
            }
            len = Math.max(helper(nums, j + 1, subLen, currentMin), len);
        }
        else
            len=helper(nums,j+1, subLen, currentMin);
        return len;
    }




    // -------------------  Solution 2 ---------------------

    public int lengthOfLISEfficient(int[] nums) {
        if(nums.length == 0) return 0;

        int[] result = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int j = findInsertionPoint(result, size, num);
            if (j == size) {
                result[size++] = num;
            } else {
                result[j] = num;
            }
        }
        return size;
    }

    /**
     * find insertion point between the range [start, end], for num
     *
     */
    private int findInsertionPoint(int[] result, int end, int num) {
        int l = 0;
        int r = end;
        while(l < r) {
            int mid = (l + r) >>> 1;
            if(result[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubSequence().lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }
}
