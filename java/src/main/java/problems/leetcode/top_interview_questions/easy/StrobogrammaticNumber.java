package problems.leetcode.top_interview_questions.easy;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num){
        int[] nums = new int[]{0,1,-1, -1, -1,-1,9,-1,8,6};
        StringBuilder sb = new StringBuilder("");
        char[] arr = num.toCharArray();
        for(int i= arr.length-1; i>=0; i--){
            if(nums[ Integer.valueOf(""+arr[i])]==-1)
                return false;
            sb.append(nums[ Integer.valueOf(""+arr[i])]);
        }
        String finalStr = sb.toString();
        return num.equals(finalStr);
    }
}
