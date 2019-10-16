package problems.leetcode.top_interview_questions.easy;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        return Integer.toString(n, 3).matches("^10*$");

    }


    /**
     * 3^19  % n should be 0.
     * https://leetcode.com/problems/power-of-three/solution/
     * @param n
     * @return
     */
    public boolean isPowerOfThreeEfficient(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
