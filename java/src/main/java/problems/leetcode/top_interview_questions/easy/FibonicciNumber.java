package problems.leetcode.top_interview_questions.easy;

public class FibonicciNumber {
    public int fib(int N) {
        int[] dp = new int[N+1];
        return fib(N, dp);
    }

    public int fib(int N, int[] dp){
        if(N==0 || N==1)
            return N;
        if(dp[N]!=0)
            return dp[N];
        dp[N]= fib(N-1, dp)+ fib(N-2, dp);
        return dp[N];
    }
}
