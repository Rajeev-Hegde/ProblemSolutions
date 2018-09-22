package com.core.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class LinearLastMatch {


    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        String arrSizeAndNumber = s.nextLine();
        String number = arrSizeAndNumber.split(" ")[1];

        List<String> numbers = Arrays.asList(s.nextLine().split(" "));

        AtomicInteger i= new AtomicInteger(1);
        AtomicInteger pos= new AtomicInteger(1);

        numbers.forEach((value)-> {
            if (value.equals(number))
                pos.set(i.get());
            i.getAndIncrement();
        });

        System.out.println(pos);
    }
}
