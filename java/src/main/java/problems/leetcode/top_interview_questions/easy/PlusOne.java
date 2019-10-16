package problems.leetcode.top_interview_questions.easy;


public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry=1, i=digits.length-1;
        for(; i>=0; i--){
            if(digits[i]+ carry > 9){
                digits[i]= 0;
                carry=1;
            }
            else{
                digits[i]= digits[i]+ carry;
                carry=0;
                break;
            }
        }

        if(carry == 1 && i==-1){
            //when length is increased, end index will be set to 0 by default since int is primitive
            digits = new int[digits.length+1];
            digits[0]= 1;
        }
        return digits;
    }
}
