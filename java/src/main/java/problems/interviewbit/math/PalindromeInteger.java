package problems.interviewbit.math;

public class PalindromeInteger {

    public int isPalindrome(int A) {
        int reversedInteger=0;
        String aStr = String.valueOf(A).replace("-","");
        for (int i = 0; i <aStr.length() ; i++) {
            reversedInteger+= Integer.parseInt(aStr.substring(i,i+1)) *((int) Math.pow(10,i));
        }
        return reversedInteger == A? 1:0;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeInteger().isPalindrome(1221));
    }
}
