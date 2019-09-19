package problems.leetcode;

public class MinimumCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int i=-1;
        int totalCost=0;
        while(i< cost.length-1){
            if((i+2)<cost.length && (cost[i+2]<= cost[i+1])){
                i+=2;
            }
            else{
                i+=1;
            }
            if(i!=cost.length-1)
                totalCost+=cost[i];
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{0,0,0,1};
        System.out.println( MinimumCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
