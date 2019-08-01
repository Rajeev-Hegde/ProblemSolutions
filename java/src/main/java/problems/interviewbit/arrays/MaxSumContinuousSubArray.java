package problems.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumContinuousSubArray {

    public static int maxSubArray(final List<Integer> A) {
        int maxEndingHere = A.get(0);
        int maxSoFar = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            maxEndingHere = Math.max(A.get(i), A.get(i) + maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSumContinuousSubArray.maxSubArray(Arrays.asList(-2,10,-1,-1,10,-3));
    }
}
