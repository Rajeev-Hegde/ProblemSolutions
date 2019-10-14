package problems.leetcode.top_interview_questions.easy;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        S=formatString(S).replaceAll("^#*","");
        T=formatString(T).replaceAll("^#*","");
        return S.equals(T);
    }

    public String formatString(String s){
        String temp= s, prev;
        do{
            prev=temp;
            temp=temp.replaceAll("[^#]#","");
        }while(!temp.equals(prev));
        return temp;
    }


    public boolean backspaceCompareFasterMethod(String S, String T) {
        return helper(S).equals(helper(T));
    }
    private String helper(String input) {
        int s = 0;
        int f = 0;
        char[]arr = input.toCharArray();
        while(f < arr.length) {
            if(arr[f]!='#') {
                arr[s] = arr[f];
                s++;
            }else if(s > 0){
                s--;
            }
            f++;
        }
        return new String(arr, 0, s);
    }

    public static void main(String[] args) {
        System.out.println(new BackSpaceStringCompare().backspaceCompare("y#fo##f","y#f#o##f"));
    }
}
