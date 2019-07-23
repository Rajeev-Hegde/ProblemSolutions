package problems.interviewbit.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
public class DuplicateInArray {

    Map<Integer,Integer> myMap = new HashMap<>();


    // wrong solution, as map is not supposed to be used as per question
    public int repeatedNumber(final List<Integer> a) {

        for (Integer num : a) {
            if(myMap.containsKey(num))
                return num;
            myMap.put(num,1);
        }
        return -1;
    }

    public int repeatedNumberImprovedVersion(final List<Integer> a){
        int slow = 0, fast = 0;
        //slow moves 1 step and fast moves 2 step in this iteration
        do{
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        }while(slow != fast);
        // They meet somewhere in the loop
        slow = 0;
        //slow moves 1 step and fast moves 1 step in this iteration
        while(slow != fast){
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
