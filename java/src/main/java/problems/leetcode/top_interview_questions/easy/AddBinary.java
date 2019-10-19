package problems.leetcode.top_interview_questions.easy;

public class AddBinary {

    public String addBinary(String a, String b) {
        String s = (a.length()>b.length())?b:a;
        String l = (a.length()>b.length())?a:b;
        StringBuilder result = new StringBuilder();
        while(s.length()<l.length()) s="0"+s;
        int carry = 0;
        for(int i=l.length()-1;i>=0;i--){
            int value = (l.charAt(i)-'0')+(s.charAt(i)-'0') + carry;
            result.insert(0,value%2);
            carry = value/2;
        }
        if(carry==1) result.insert(0,1);
        return result.toString();
    }
}
