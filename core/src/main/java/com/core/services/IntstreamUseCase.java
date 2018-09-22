package com.core.services;

import java.util.stream.IntStream;

public class IntstreamUseCase {


    /**
     * Prints sum of all divisors for a given number
     * @param args
     */
    public static void main(String[] args) {
        int sum;
        final int k= 6;
        sum = IntStream.rangeClosed(1, k).filter(num -> k % num == 0).sum();
        System.out.println(sum );
    }
}
