package com.core.contests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultipleOfXYNotZ {


    public static List<Integer> multiple(int x, int y, int z, int n) {
        // Write your code here

        List<Integer> requiredNumbers= IntStream.range(1, n+1)
                .filter(num-> ((x!=0 && num % x ==0) || (y!=0 && num % y == 0)) && (z!=0 && num %z !=0))
                .boxed().collect(Collectors.toList());
        return requiredNumbers;
    }

    public static void main(String[] args) {
        new MultipleOfXYNotZ().multiple(3,5,10,12);
    }
}

