package problems;

import java.util.Scanner;

public class OccuranceofA {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count=0;
        long repeatCount = n/s.length();
        long subStringLength= n % s.length();
        int totalChRepeatInString=0;
        int partialIncluded = 0;
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            if (chars[i] == 'a'){
                totalChRepeatInString++;
                if(subStringLength> i)
                    partialIncluded++;
            }
        }

        return totalChRepeatInString*repeatCount + partialIncluded;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
