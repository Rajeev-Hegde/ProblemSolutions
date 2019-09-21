package problems.leetcode.contest;

import java.util.Arrays;

public class AppleAndBasket {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        int sum=5000;
        for (int num :arr){
            if(num <= sum){
                count++;
                sum-=num;
            }
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new AppleAndBasket().maxNumberOfApples(new int[]{900,950,800,1000,700,800}));
    }
}
