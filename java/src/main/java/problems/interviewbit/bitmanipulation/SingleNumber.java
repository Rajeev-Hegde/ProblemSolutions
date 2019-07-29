package problems.interviewbit.bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    public int singleNumber(final List<Integer> A) {
        int i=1;
        int finalInt=A.get(0);
        while (i< A.size()){
            finalInt = finalInt ^ A.get(i);
            i++;
        }

        return finalInt;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(Arrays.asList(0,2,3,4,4,2,0)));
    }
}
