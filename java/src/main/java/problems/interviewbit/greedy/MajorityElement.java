package problems.interviewbit.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

   /*
   Solution which uses O(n) Auxiliary space
   public int majorityElement(final List<Integer> A) {
        Map<Integer,Integer> nameVsOccurrence = new HashMap<>();
        for(int i=0; i< A.size(); i++){
            nameVsOccurrence.putIfAbsent(A.get(i),1);
            nameVsOccurrence.merge(A.get(i),1, (a,b)-> a+b);
        }
        return nameVsOccurrence.entrySet()
                .stream()
                .filter(entry-> entry.getValue()> Math.floor(A.size()/2)).findFirst().get().getKey();
    }
    */

    // Greedy method which uses constant Auxiliary space
    public int majorityElement(final List<Integer> A) {
        int elem=A.get(0);
        int count=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)==elem){
                count++;
            }else{
                count--;
            }
            if(count==0){
                elem=A.get(i);
                count=1;
            }
        }
        return elem;
    }

    public static void main(String[] args) {

    }
}
