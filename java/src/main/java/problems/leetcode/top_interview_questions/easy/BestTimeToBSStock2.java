package problems.leetcode.top_interview_questions.easy;

public class BestTimeToBSStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i< prices.length; i++ ){
            if(i+1<prices.length && prices[i]< prices[i+1]){
                maxProfit+=prices[i+1]-prices[i];
            }
        }
        return maxProfit;

    }
}
