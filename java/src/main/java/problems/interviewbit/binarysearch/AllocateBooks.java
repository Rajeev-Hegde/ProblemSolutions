package problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

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


    public int books(ArrayList<Integer> A, int B) {
        long sum=0;

        for (Integer aA : A) {
            sum += aA;
        }
        int start=0, end= (int) sum;
        int result = Integer.MAX_VALUE;
        while(start<=end){
            int mid = (start+end)/2;

            if(isMinimumPossible(A,B,mid)){
                result= Math.min(result,mid);
                end=mid-1;
            }
            else
                start= mid+1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AllocateBooks().books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)),2));
    }
}
