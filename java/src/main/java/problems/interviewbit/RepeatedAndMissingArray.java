package problems.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatedAndMissingArray {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.size();

        long sumOfNum = (((long) n) * ((long) n + 1)) / 2;
        long sumOfSq = (((long) n) * ((long) n + 1) * ((long) 2*n + 1)) / 6;

        for (int i=0; i < n; i++) {
            sumOfNum -= (long) A.get(i);
        }

        for (int i=0; i < n; i++) {
            sumOfSq -= (long) A.get(i) * (long) A.get(i);
        }

        long sumNum = sumOfSq/sumOfNum;

        int missing = (int) (sumNum + sumOfNum)/2;
        int repeated = (int) (sumNum - missing);

        res.add(repeated);
        res.add(missing);

        return res;
    }
}
