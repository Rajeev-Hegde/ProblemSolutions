package problems.leetcode.top_interview_questions.easy;

public class HappyNumber {

    public boolean isHappy(int n) {

        int i,sum;
        int[] hash=new int[500];
        while(true)
        {
            sum=0;
            while(n!=0)
            {
                i=n%10;
                sum+=i*i;
                n=n/10;
            }
            hash[sum]++;
            if(hash[sum]>1)
            {
                return false;
            }
            n=sum;
            if(sum==1)
                return true;
        }
    }
}
