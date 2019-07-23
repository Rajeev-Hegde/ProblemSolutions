package problems.interviewbit.arrays;

import java.util.ArrayList;

public class ConcentricCircles {

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        ArrayList<ArrayList<Integer>> myMatrix = new ArrayList<>();
        for (int i = 0; i < 2 * A - 1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            int k=2;
            for (int j = 0; j < 2*A-1; j++) {
                if(i<A && j< A )
                    row.add(Math.abs(A-Math.min(i,j)));
                else if(i< A){
                    row.add(row.get(j-k));
                    k+=2;
                }
                else{
                    int x= i%(A-1);
                    row.add(myMatrix.get(x).get(j));
                }
            }
            myMatrix.add(row);
        }
        return myMatrix;
    }

    public static void main(String[] args) {
        new ConcentricCircles().prettyPrint(3);
    }
}
