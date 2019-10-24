package problems.leetcode.top_interview_questions.hard;

/**
 * IMPORTANT
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        if (height.length < 2) return 0;
        maxLeftHeight[0] = height[0];
        maxRightHeight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxLeftHeight[i] = Math.max(height[i], maxLeftHeight[i - 1]);
        }

        for (int i = height.length - 2; i > 0; i--) {
            maxRightHeight[i] = Math.max(height[i], maxRightHeight[i + 1]);
        }

        int totalTrappedWater = 0;

        for (int i = 1; i < height.length - 1; i++) {
            if (Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i] > 0)
                totalTrappedWater += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }
        return totalTrappedWater;
    }


    public int trapEfficient(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (i <= j) {
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[j], rightMax);
            if (leftMax < rightMax) {
                res += leftMax - height[i++];
            } else {
                res += rightMax - height[j--];
            }
        }
        return res;
    }
}
