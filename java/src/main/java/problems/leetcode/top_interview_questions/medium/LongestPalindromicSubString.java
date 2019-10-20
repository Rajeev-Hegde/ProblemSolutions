package problems.leetcode.top_interview_questions.medium;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        int maxLength=0, x=0;
        for(int i=0; i< s.length(); i++){
            int j=i-1;
            int[] details= getPalindromeDetails(s,j,i+1,1);
            j= details[0];
            int currentLength = details[1];
            if(currentLength> maxLength){
                maxLength =  currentLength;
                x= j+1;
            }
        }
        for(int i=0; i< s.length(); i++){
            int j=i;
            int[] details= getPalindromeDetails(s,j,i+1,0);
            j= details[0];
            int currentLength = details[1];
            if(currentLength> maxLength){
                maxLength =  currentLength;
                x= j+1;
            }
        }
        return s.substring(x, x+maxLength);
    }

    public int[] getPalindromeDetails(String s, int j, int k, int currentLength){
        while(j>=0 && k< s.length()){
            if(s.charAt(j)!= s.charAt(k))
                break;
            j--;
            k++;
            currentLength+=2;
        }
        return new int[]{j,currentLength};
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubString().longestPalindrome("cbbd"));
    }
}
