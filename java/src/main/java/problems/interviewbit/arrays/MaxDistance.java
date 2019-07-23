package problems.interviewbit.arrays;

import java.util.*;

public class MaxDistance {

    public int maximumGap(final List<Integer> A) {

        int maxDiff;
        int i, j;
        int n = A.size();

        int[] LMin = new int[n];
        int[] RMax = new int[n];

       /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = A.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(A.get(i), LMin[i-1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n-1] = A.get(n-1);
        for (j = n-2; j >= 0; --j)
            RMax[j] = Math.max(A.get(j), RMax[j+1]);

        /* Traverse both arrays from left to right to find optimum j - i
            This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = 0;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                maxDiff = Math.max(maxDiff, j-i);
                j = j + 1;
            }
            else
                i = i+1;
        }

        return maxDiff;
    }


    //recursive solution
    public int recursiveSolution(List<Integer> list){
        int size = list.size();

        if (size <= 1) {
            return -1;
        }

        if (list.get(0) <= list.get(size - 1)) {
            return size - 1;
        }

        // Max between list[0:size-1] and list[1:size]
        return Math.max(
                maximumGap(list.subList(0, size - 1)),
                maximumGap(list.subList(1, size))
        );
    }


    public static void main(String[] args) {
        System.out.println(new MaxDistance().maximumGap(Arrays.asList(3, 5, 4, 2)));
    }
}
