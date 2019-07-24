package problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {


    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int l=A.size();
        int count=0;
        long num=0;
        /*if(l==1)
        {
            if((int)A.get(0)==0)
            return
        }*/
        for(int i=0;i<l;i++)
        {
            if((int)A.get(i)==0)
                count++;
            else
                break;
        }
        for(int j=count;j<l;j++)
        {
            if(l-j-1 ==0)
                num+=A.get(j);
            else
                num+=Math.pow(((A.get(j))*10),l-j-1);
        }
        num+=1;
        String temp = Long.toString(num);
        ArrayList<Integer> newGuess = new ArrayList<Integer>(temp.length());
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess.add((Integer)(temp.charAt(i) - '0'));
        }
        return newGuess;
    }

    public static void main(String[] args) {
        System.out.println(new AddOneToNumber().plusOne(new ArrayList<>(Arrays.asList(0,1,2,3))));
    }
}
