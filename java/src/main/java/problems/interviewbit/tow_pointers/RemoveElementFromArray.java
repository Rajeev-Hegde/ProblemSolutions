package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

    /* If solution is space constraint, and if value has to be removed from array then use this
    public int removeElement(ArrayList<Integer> a, int b) {

        int i = 0, j = a.size()-1, totalRemaining = a.size();
        while (i <= j) {
            if (a.get(i) == b) {
                a.remove(i);
                totalRemaining--;
                j--;
            } else {
                i++;
            }
            if (i < j)
                if (a.get(j) == b) {
                    a.remove(j);
                    totalRemaining--;
                    j--;
                } else
                    j--;
        }
        return totalRemaining;
    }*/

    public int removeElement(ArrayList<Integer> a, int b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b) {
                a.set(count,a.get(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElementFromArray().removeElement(new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3)),
                1));
    }
}
