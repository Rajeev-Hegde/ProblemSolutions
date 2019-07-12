package algorithms;

import java.util.Scanner;

public class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = 0;
        for(int i=0; i < arr.length-2; i++){
            for (int j=0; j< arr.length-2; j++){
                int currentSum= arr[i][j]+ arr[i][j+1]+ arr[i][j+2] + arr[i+1][j+1]+arr[i+2][j]+ arr[i+2][j+1]+ arr[i+2][j+2];
                if(maxSum< currentSum)
                    maxSum=currentSum;
            }
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            if(i+1!=6)
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);
        scanner.close();
    }
}
