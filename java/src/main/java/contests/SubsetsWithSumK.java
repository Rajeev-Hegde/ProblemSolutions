package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: fix this problem
public class SubsetsWithSumK {



    static List<List<Integer>> possibleSubsets = new ArrayList<>();


    public static boolean findAllSubSetsWithSumK(List<Integer> array, List<Integer>subsetArray,int pos,int sum){


        if(pos> array.size()) {
            possibleSubsets.add(new ArrayList<>(subsetArray));
            return false;
        }

        subsetArray.add(array.get(pos));
        if(!findAllSubSetsWithSumK(array, subsetArray, pos + 1, sum-array.get(pos)))
            return false;
        subsetArray.remove(array.get(pos));
        if(! findAllSubSetsWithSumK(array, subsetArray, pos + 2, sum))
            return false;
        subsetArray.remove(array.get(pos));
        if(sum<0) {
            subsetArray.remove(subsetArray.size()-1);
            return false;
        }
        if(sum==0) {
            possibleSubsets.add(new ArrayList<>(subsetArray));
            subsetArray.remove(subsetArray.size()-1);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        SubsetsWithSumK.
                findAllSubSetsWithSumK(Arrays.asList(1,3,5,7,8),new ArrayList<>(),0,8);
        System.out.println(possibleSubsets);
    }
}
