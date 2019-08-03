package com.core.contests;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FindNthNumber {

    //This requires array to be sorted
    static boolean binarySearch(List<Integer> arr, int l, int r ,int k){

        while(l<=r) {
            int mid = l + (r - 1) / 2;
            if (arr.get(mid) == k)
                return true;

            if (k < arr.get(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }


    static String findNumber(List<Integer> arr, int k) {
        int last=arr.size()-1;
        if (arr.get(arr.size()-1) == k)
            return "YES";

        int backup = arr.get(last);
        arr.set(last,k);

        // no termination condition and thus
        // no comparison
        for (int i = 0;; i++) {
            // this would be executed at-most n times
            // and therefore at-most n comparisons
            if (arr.get(i) == k) {
                // replace arr[n-1] with its actual element
                // as in original 'arr[]'
                arr.set(last, backup);

                // if 'x' is found before the '(n-1)th'
                // index, then it is present in the array
                // final comparison
                if (i < last)
                    return "NO";

                // else not present in the array
                return "YES";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arrTemp = new ArrayList<>();

        IntStream.range(0, arrCount).forEach(i -> {
            try {
                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> arr = arrTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
