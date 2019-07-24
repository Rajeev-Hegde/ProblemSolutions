package problems.interviewbit.strings_problems;

public class PalindromeString {

    public int isPalindrome(String A) {
        A = A.trim();
        int i=0,k=A.length()-1;
        while(i< k){
            while (i< k && !String.valueOf(A.charAt(i)).matches("[0-9a-zA-Z]")){
                i++;
            }
            while (i< k && !String.valueOf(A.charAt(k)).matches("[0-9a-zA-Z]")){
                k--;
            }
            if(i<k)
                if(String.valueOf(A.charAt(i)).equalsIgnoreCase(String.valueOf(A.charAt(k)))){
                    i++;
                    k--;
                }
                else
                    return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeString().isPalindrome("1a2"));
    }
}
