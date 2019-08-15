package problems.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class AssignMiceToHoles {


    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A == null || B == null || A.size() != B.size())
            return -1;
        int totalTime = Integer.MIN_VALUE;
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.naturalOrder());


        for(int i =0; i < A.size(); i++){
            totalTime = Math.max(Math.abs(B.get(i) - A.get(i)),totalTime);
        }
        return  totalTime;
    }

    public static void main(String[] args) {

    }
}
