package problems.interviewbit.binarysearch;

import java.util.ArrayList;

public class PaintersPartitionProblem {


    private boolean isMinimumPossible(ArrayList<Integer> a, int m, int curMin){
        int studentsRequired=1,currentSum=0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)> curMin)
                return false;
            if(currentSum+ a.get(i) > curMin){
                studentsRequired++;
                currentSum = a.get(i);

                if (studentsRequired > m)
                    return false;
            }
            else
                currentSum+=a.get(i);
        }
        return true;
    }


    public int paint(int A, int B, ArrayList<Integer> C) {
        long sum=0;

        for (Integer aA : C) {
            sum += aA;
        }
        int start=0, end= (int) sum;
        long result = Long.MAX_VALUE;
        while(start<=end){
            int mid = (start+end)/2;

            if(isMinimumPossible(C,A,mid)){
                result= Math.min(result,mid);
                end=mid-1;
            }
            else
                start= mid+1;
        }

        long a= (result*B)%10000003L;
        return (int)a;
    }


    public static void main(String[] args) {
        int a = 10000003;

    }
}
