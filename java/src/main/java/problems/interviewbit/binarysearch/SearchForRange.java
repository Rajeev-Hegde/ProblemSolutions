package problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchForRange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        Integer l=0;
        Integer r=a.size() - 1;
        while (l <= r) {
            int m = (l+r)/2;

            // Check if x is present at mid
            if (a.get(m) == b){

                int startIndex=m, endIndex=m;
                while(startIndex>=0 && a.get(startIndex)==b){
                    startIndex--;
                }
                while(endIndex< a.size() && a.get(endIndex)==b){
                    endIndex++;
                }
                return new ArrayList<>(Arrays.asList(startIndex+1,endIndex-1));
            }
            if (a.get(m) < b)
                l = m + 1;
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return new ArrayList<>(Arrays.asList(-1,-1));
    }

    public static void main(String[] args) {
        System.out.println(new SearchForRange().searchRange(new ArrayList<>(Arrays.asList(1)),1));
    }
}
