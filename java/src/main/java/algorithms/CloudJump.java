package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CloudJump {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        //for(int i=0; c.)
        int totalJumps = 0;
        for(int i=1;i <c.length; i++){
            if(i+1 < c.length && c[i+1]==0)
                i++;
            totalJumps+=1;
        }
        return totalJumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(result);
        scanner.close();
    }
}
