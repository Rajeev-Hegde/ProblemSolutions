package problems.leetcode.top_interview_questions.easy;

/**
 * IMPORTANT
 */
public class PowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }


}
