package problems.interviewbit.binarysearch;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {


    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        BigInteger sum = new BigInteger("0");
        for (Integer integer : a) {
            sum = sum.add(new BigInteger(String.valueOf(integer)));
        }
        for (Integer integer : b) {
            sum = sum.add(new BigInteger(String.valueOf(integer)));
        }
        BigInteger length = new BigInteger (String.valueOf (a.size()+ b.size()));
        return sum.divide(length).doubleValue();
    }


    public static void main(String[] args) {
        System.out.println(new MedianOfArray().findMedianSortedArrays(Arrays.asList(-50, -41, -40, -19, 5, 21, 28),
                Arrays.asList(-50, -21, -10)));
    }
}
