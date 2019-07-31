package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Diffk {


    public int diffPossible(ArrayList<Integer> A, int B) {
        int i=A.size()-1;

        while (i>=0){
            int j=0;
            while (i> j){
                int diff= A.get(i)- A.get(j);
                if(diff == B)
                    return 1;
                else if(diff< B)
                    break;
                j++;
            }
            i--;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Diffk().diffPossible(new ArrayList<>(Arrays.asList(1, 3, 5)),4));
    }
}
