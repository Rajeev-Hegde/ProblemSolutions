package problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {


    /* not efficient soln
    public int modifiedBinarySearch(List<Integer> a, int l, int r, int x){
        int pos = -1;
        if(r>=l){
            int mid = (l+r)/2;
            if (a.get(mid)== x)
                return mid;

            pos=modifiedBinarySearch(a,l,mid-1,x);

            if(pos==-1) pos = modifiedBinarySearch(a, mid+1,r, x);

        }
        return  pos;
    }*/

    public int modifiedBinarySearch(List<Integer> a, int l, int r, int x){
        int pos = -1;
        if(r>=l){
            int mid = (l+r)/2;
            if (a.get(mid)== x)
                return mid;

            if(a.get(l) <= a.get(mid)){
                if(a.get(l)<=x && x<a.get(mid)){
                    return modifiedBinarySearch(a,l, mid-1, x);
                }else{
                    return  modifiedBinarySearch(a, mid+1, r, x);
                }
            }else {
                if(a.get(mid)<x&& x<=a.get(r)){
                    return  modifiedBinarySearch(a,mid+1, r, x);
                }else{
                    return  modifiedBinarySearch(a, l, mid-1, x);
                }
            }

        }
        return  pos;
    }

    public int search(final List<Integer> a, int b) {
        return modifiedBinarySearch(a,0, a.size()-1, b);
    }

    public static void main(String[] args) {
        System.out.println(new RotatedSortedArraySearch()
                .search(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177),
                        42));
    }
}
