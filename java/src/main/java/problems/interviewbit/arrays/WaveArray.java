package problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WaveArray {


    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        for (int i=0;i<A.size()-1;i+=2) {
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, temp);
        }

        return A;
    }



    public static void main(String[] args) {
        System.out.println(new WaveArray().wave(new ArrayList<>(Arrays.asList(1,2,3,4))));
    }
}
