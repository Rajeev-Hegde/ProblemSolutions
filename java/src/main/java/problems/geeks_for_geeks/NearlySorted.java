package problems.geeks_for_geeks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NearlySorted {

    //TODO: Incomplete solution. Complete this
    public static void sort(List<Integer> arr, int k){
        for( int i = 0 ;i < arr.size() ; i++ ) {
    /*storing current element whose left side is checked for its
             correct position .*/

            int temp = arr.get( i );
            int j = i;

       /* check whether the adjacent element in left side is greater or
            less than the current element. */

            while(  j > 0  && temp < arr.get( j -1)) {

                // moving the left side element to one position forward.
                arr.set( j , arr.get( j-1));
                j= j - 1;

            }
            // moving current element to its  correct position.
            arr.set( j , temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases=scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<Integer> arr= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        sort(arr, k);
        System.out.println(arr);
    }
}
