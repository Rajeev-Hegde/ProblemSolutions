package problems.interviewbit.arrays;

import java.util.ArrayList;

public class InfiniteGrid {


    public int coverPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

        int totalSteps = 0;
        for (int i=0; i< a.size();i++){
            int x = a.get(i);
            int y = b.get(i);

            if(i+1 != a.size()) {
                if (Math.abs(x - a.get(i+1)) > Math.abs(y - b.get(i+1)))
                    totalSteps+=Math.abs(x - a.get(i+1));
                else
                    totalSteps+=Math.abs(y - b.get(i+1));
            }
        }
        return totalSteps;
    }

    public static void main(String[] args) {

    }
}
