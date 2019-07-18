package problems;

import java.util.*;

public class CountTriplets {

    /* non efficient solution
    static long countTriplets(List<Long> arr, long r) {
        long total =0;
        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = i + 1; j <= arr.size() - 2; j++) {
                if (arr.get(i) * r == arr.get(j)) {
                    for (int k = j + 1; k <= arr.size() - 1; k++) {
                        if(arr.get(k) == arr.get(j) * r) {
                            total++;
                        }
                        else if (arr.get(k) > arr.get(j) * r) {
                            break;
                        }
                    }
                } else if(arr.get(i) * r < arr.get(j)){
                    break;
                }
            }
        }
        return total;
    }*/

    // efficient solution using map
    static long countTriplets(List<Long> arr, long r) {
        Long [] total = new Long[]{0L};
        Map<Long,Long> numCount = new HashMap<>();
        arr.forEach(num-> {
            numCount.merge(num,1L,Long::sum);
        });

        if(r == 1){
            numCount.getOrDefault(1L,0L);
        }
        else

        arr.forEach(num-> {
            if(numCount.containsKey(num*r) && numCount.containsKey(num*r*r))
                total[0]=total[0]+ numCount.get(num) * numCount.get(num * r) * numCount.get(num * r * r);
        });
        return total[0];
    }

    public static void main(String[] args) {
        List<Long> array = Arrays.asList(1L,3L, 2L);
        array.sort(Comparator.comparingLong(value -> value));
        System.out.println(array);
        System.out.println(CountTriplets.countTriplets(array,1L));
    }
}
