package problems.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class SmallestCommonInMatrix {

    public int smallestCommonElement(int[][] mat) {

        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i=0; i< mat[0].length; i++)
            lookup.put(mat[0][i], 1);

        for(int i=1; i< mat.length; i++){
            for(int j=0; j< mat[i].length; j++){
                if(lookup.get(mat[i][j])!=null && lookup.get(mat[i][j]) == i){
                    lookup.put(mat[i][j], i + 1);

                    if (lookup.get(mat[i][j]) == mat.length - 1)
                        return mat[i][j];
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3,4,5},
                {2,4,5,8,10},
                {3,5,7,9,11},
                {1,3,5,7,9}};
        System.out.println(new SmallestCommonInMatrix().smallestCommonElement(mat));
    }

}
