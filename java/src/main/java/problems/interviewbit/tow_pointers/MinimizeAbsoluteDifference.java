package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeAbsoluteDifference {


    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int minAbsoluteDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<A.size() && j<B.size() && k<C.size()) {
            int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

            if (maximum - minimum < minAbsoluteDiff) {
                minAbsoluteDiff = maximum - minimum;
            }

            if (minAbsoluteDiff == 0) break;

            if (A.get(i) == minimum) i++;
            else if (B.get(j) == minimum) j++;
            else k++;
        }

        return minAbsoluteDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));
        System.out.println(new MinimizeAbsoluteDifference().solve(A,B,C));
    }
}
