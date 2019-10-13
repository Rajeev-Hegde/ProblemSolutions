package problems.leetcode.top_interview_questions.easy;

public class ConfusingNumber {
    public boolean confusingNumber(int N) {
        int[] arr = new int[]{1,1,0,0,0,0,1,0,1,1};
        while(N!=0){
            int sub = N%10;
            if(arr[sub]==0)
                return false;
            N=N/10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ConfusingNumber().confusingNumber(11));
    }
}
