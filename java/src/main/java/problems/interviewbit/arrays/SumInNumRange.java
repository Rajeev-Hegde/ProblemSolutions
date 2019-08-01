package problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SumInNumRange {


    public int numRange(ArrayList<Integer> A, int B, int C) {

        int totalPossibilities=0;

        for (int i = 0; i < A.size(); i++) {
            int j=i;
            int maxSoFar=0;
            while(j < A.size()){
                int currentMax=maxSoFar+ A.get(j);
                if (currentMax >=B && currentMax<= C){
                    maxSoFar=currentMax;
                    totalPossibilities++;
                }
                else if(currentMax< B){
                    maxSoFar=currentMax;
                }
                else
                    break;
                j++;
            }
        }
        return totalPossibilities;
    }


    public static void main(String[] args) {
        System.out.println(new SumInNumRange()
                .numRange(new ArrayList<>(Arrays.asList(
                        80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90)),
                        99,
                        269));
    }
}
