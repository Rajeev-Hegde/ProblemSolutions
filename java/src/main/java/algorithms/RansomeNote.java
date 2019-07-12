package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RansomeNote {


    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> arr1 = new HashMap<>();
        Map<String,Integer> arr2 = new HashMap<>();

        for(String str: magazine){
            arr1.put(str, arr1.getOrDefault(str,0)+1 );
        }

        for (String str: note){
            arr2.put(str, arr2.getOrDefault(str,0)+1);
        }

        boolean possible = true;
        for (Map.Entry<String, Integer> entry : arr2.entrySet()) {
            String str = entry.getKey();
            Integer count = entry.getValue();
            if (!(arr1.containsKey(str) && arr1.get(str) > count)) {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "Yes" : "No");
    }


    public static void main(String[] args) {

    }
}
