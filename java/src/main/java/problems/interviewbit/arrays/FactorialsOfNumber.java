package problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FactorialsOfNumber {

    public ArrayList<Integer> allFactors(int A) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A%i==0){
                list.add(i);
                if(i!=Math.sqrt(A))
                    list.add(A/i);
            }
        }
        Collections.sort(list);
        return list;
    }
}
