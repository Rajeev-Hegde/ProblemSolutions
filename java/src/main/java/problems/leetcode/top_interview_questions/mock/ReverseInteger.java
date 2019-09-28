package problems.leetcode.top_interview_questions.mock;

public class ReverseInteger {


    //Hacky way
    public int reverse(int x) {
        boolean isNegative= x<0;
        String xString= String.valueOf(x).replaceFirst("-","");
        try{
            return (isNegative? -1: 1)* Integer.parseInt(new StringBuilder(xString).reverse().toString());
        }catch(Exception e){
            return 0;
        }
    }

    int reverseDigits(int num)
    {
        // Handling negative numbers
        boolean negativeFlag = false;
        if (num < 0)
        {
            negativeFlag = true;
            num = -num ;
        }

        int prev_rev_num = 0, rev_num = 0;
        while (num != 0)
        {
            int curr_digit = num%10;

            rev_num = (rev_num*10) + curr_digit;

            if ((rev_num - curr_digit)/10 != prev_rev_num)
            {
                System.out.println("OVERFLOWED!!!");
                return 0;
            }

            prev_rev_num = rev_num;
            num = num/10;
        }

        return (negativeFlag)? -rev_num : rev_num;
    }


    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-20));
        System.out.println(new ReverseInteger().reverseDigits(-20));
    }
}
