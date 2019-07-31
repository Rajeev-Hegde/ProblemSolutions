package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {

    public int maxArea(ArrayList<Integer> A) {

        int i=0, j=A.size()-1;

        int maxArea= 0;
        while (i<j){

            int currentArea;
            if(A.get(i)< A.get(j)){
               currentArea = (j-i)* A.get(i);
                i++;
            }
            else {
                currentArea = (j-i)* A.get(j);
                j--;
            }
            if(currentArea> maxArea)
                maxArea = currentArea;

        }

        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new ArrayList<>(Arrays.asList(1, 5, 4, 3))));
    }
}
