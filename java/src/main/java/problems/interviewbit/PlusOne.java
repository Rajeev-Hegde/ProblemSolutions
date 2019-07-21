package problems.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {

    //Will not work for large integers
    public ArrayList<Integer> plusOneOld(ArrayList<Integer> A) {
        long total = 0;
        long j = 0;
        for (int i = A.size() - 1; i >= 0; i--) {
            total += A.get(i) * Math.pow(10, j);
            j++;
        }
        total++;
        return new ArrayList<>(Arrays.stream(String.valueOf(total).split("")).map(Integer::valueOf).collect(Collectors.toList()));
    }


    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int i = 0;
        //remove zeroes at the front
        while (i < a.size() - 1 && a.get(i) == 0) {
            a.remove(i);
        }

        int carry = 1;
        int sum;
        for (i = a.size() - 1; i >= 0; i--) {
            sum = a.get(i) + carry;
            a.set(i, sum % 10);
            carry = sum / 10;
            // no need of further processing if carry is zero
            if (carry == 0) {
                break;
            }
        }
        // if carry is still left
        if (carry != 0) {
            a.add(0, carry);
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.
                println(new PlusOne()
                        .plusOne(new ArrayList<>(Arrays.asList(9))));
    }
}
