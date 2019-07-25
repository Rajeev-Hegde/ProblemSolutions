package problems.interviewbit.strings_problems;

public class MinCharToMakePalindrome {


    public int solve(String A) {

        int i=0,j=A.length()-1;

        if (A.length()==0)
            return 0;
        while(i< j){
            int k=i, l=j;
            while(k< l && A.charAt(k)== A.charAt(l)){
                k++;
                l--;
            }
            if(k>=l){
                return A.length() - (j+1);
            }
            j--;
        }
        return A.length()-1;
    }

    public static void main(String[] args) {
        System.out.println(new MinCharToMakePalindrome().solve("abcbaef"));
    }
}
