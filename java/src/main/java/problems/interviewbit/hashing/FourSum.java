package problems.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        A.sort(Comparator.naturalOrder());

        for (int i = 0; i < A.size() - 3; i++) {
            for (int j = i+1; j < A.size() - 2; j++) {
                int sumRemaining = B- (A.get(i)+A.get(j));
                int k=j+1, l= A.size()-1;
                while(k< l){
                    int otherTwoSum = A.get(k)+ A.get(l);
                    if(sumRemaining -otherTwoSum == 0) {
                        res.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k), A.get(l))));
                        while(k+1< l && A.get(k+1).intValue()== A.get(k))
                            k++;
                        while(l-1> k && A.get(l-1).intValue()== A.get(l))
                            l--;
                        l--;
                    }
                    else if(otherTwoSum < sumRemaining){
                        k++;
                    }
                    else
                        l--;
                }
                while((j+1)< (A.size() - 2) && A.get(j+1).intValue()==A.get(j))
                    j++;

            }
            while(i+1< (A.size() - 3) && A.get(i+1).intValue()==A.get(i))
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new FourSum().fourSum(new ArrayList<>
                (Arrays.asList(1, 0 ,-1, 0, -2 ,2)),0));
    }
}
