package problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

    public int performSearch(ArrayList<Integer> arr, int l, int r, int num){
        while(l<=r){

            int mid = (l+r)/2;
            if(arr.get(mid)== num)
                return 1;

            if (num <arr.get(mid))
                r= mid-1;

            else if (num> arr.get(mid))
                l= mid+1;
        }
        return 0;
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        int rowToConsider = a.size()/2;
        int increaseValue=-1;
        while(rowToConsider>=0 && rowToConsider <a .size()){
            ArrayList<Integer> arr = a.get(rowToConsider);
            if(arr.size()>0 && arr.get(0)<=b && arr.get(arr.size()-1)>=b){
                return performSearch(arr, 0, arr.size()-1, b);
            }
            else if (arr.size()>0 && arr.get(0)>b) {
                if(increaseValue==1)
                    return 0;
                rowToConsider--;
                increaseValue=0;
            }
            else{
                if(increaseValue==0)
                    return 0;
                rowToConsider++;
                increaseValue=1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        ArrayList<Integer> rowArray1 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> rowArray2 = new ArrayList<>(Arrays.asList(10));
        ArrayList<Integer> rowArray3 = new ArrayList<>(Arrays.asList(23));
        a.add(rowArray1);
        a.add(rowArray2);
        a.add(rowArray3);
        System.out.println(new MatrixSearch().searchMatrix(a,22));
    }
}
