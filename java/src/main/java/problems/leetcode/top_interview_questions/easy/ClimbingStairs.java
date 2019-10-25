package problems.leetcode.top_interview_questions.easy;

public class ClimbingStairs {
    // ---------------- Solution 1 ----------------

    public int climbStairs(int n) {
        int[] res = new int[]{0};
        climbStairs(n, 0, res);
        return res[0];
    }


    public void climbStairs(int n, int i, int[] res){
        if(i==n){
            res[0]++;
        }

        if(i+1 <=n)
            climbStairs(n,i+1,res);
        if(i+2 <=n)
            climbStairs(n,i+2,res);
    }

    // ----------------- Solution 2 ----------------

    public int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        return climb(n, dp);
    }

    public int climb(int n, int[] dp){
        if(n <= 2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {

        //System.out.println(new ClimbingStairs().climbStairs(18));
        System.out.println(Integer.MAX_VALUE);
    }
}
