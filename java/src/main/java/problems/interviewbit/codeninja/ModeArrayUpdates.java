package problems.interviewbit.codeninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModeArrayUpdates {


    public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        Map<Integer,Integer> valueCount=new HashMap<>();
        A.forEach(num-> {valueCount.putIfAbsent(num,0); valueCount.merge(num,1,(a, b) -> a + b);} );
        ArrayList<Integer> result= new ArrayList<>();
        for (ArrayList<Integer> aB : B) {

            int index = aB.get(0);
            int newNumber = aB.get(1);
            int numberToReplace = A.get(index - 1);
            if (valueCount.containsKey(numberToReplace))
                valueCount.put(numberToReplace, valueCount.get(numberToReplace) != 0 ? (valueCount.get(numberToReplace) - 1) : 0);
            valueCount.putIfAbsent(newNumber, 0);
            valueCount.merge(newNumber, 1, (a, b) -> a + b);
            A.set(index - 1, newNumber);
            result.add(findMax(valueCount));
        }

        return result;
    }

    public int findMax(Map<Integer,Integer> valueCount){
        int currentMax=0;
        int currentKey = -1;
        for (Map.Entry<Integer,Integer> keyValue :valueCount.entrySet()){
            if (keyValue.getValue()>currentMax) {
                currentMax=keyValue.getValue();
                currentKey = keyValue.getKey();
            }
            else if(keyValue.getValue()==currentMax && keyValue.getKey()< currentKey )
                currentKey = keyValue.getKey();
        }
        return currentKey;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A  = new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        ArrayList<Integer> op1 = new ArrayList<>(Arrays.asList(1, 3));
        ArrayList<Integer> op2 = new ArrayList<>(Arrays.asList(5, 4));
        ArrayList<Integer> op3 = new ArrayList<>(Arrays.asList(2,4));
        B.add(op1);
        B.add(op2);
        B.add(op3);
        System.out.println(new ModeArrayUpdates().getMode(A,B));
    }
}
