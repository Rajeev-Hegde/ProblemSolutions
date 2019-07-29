package problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    int getPositionOfElement(ArrayList<Integer>arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) == x)
                return mid;

            if (arr.get(mid) > x)
                return getPositionOfElement(arr, l, mid - 1, x);
            else if( mid+1 > arr.size() || (mid+1)< arr.size() && arr.get(mid)<x && arr.get(mid+1)> x )
                return mid+1;

            return getPositionOfElement(arr, mid + 1, r, x);
        }

        if(r<=0)
            return 0;
        return arr.size();
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        return getPositionOfElement(a,0, a.size()-1,b);
    }

    public static void main(String[] args) {
        System.out.println(new SortedInsertPosition().searchInsert(new ArrayList<>(Arrays.asList(1,3,5,6,8)),4));
    }
}
