package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionOfSortedArrays {

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i=0,j=0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i< A.size() && j< B.size()){
            if (A.get(i).equals(B.get(j))) {
                res.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i) < B.get(j))
                i++;
            else
                j++;

        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98));
        System.out.println(new InsertionOfSortedArrays().intersect(a,b));
    }
}
