package problems.interviewbit.hashing;

import java.util.*;

public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer,Integer> numVsIndexMap = new HashMap<>();
        int j=0;
        while(j < A.size()){
            if (!numVsIndexMap.containsKey(A.get(j))){
                numVsIndexMap.putIfAbsent(B- A.get(j),j+1);
            }
            else{
                return new ArrayList<>(Arrays.asList(numVsIndexMap.get(A.get(j)),j+1));
            }
            j++;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(new TwoSum().twoSum(new ArrayList<>(
                Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8)),
                -3));
    }
}
