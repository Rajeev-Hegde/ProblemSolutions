package com.core.algorithms;

import java.util.Arrays;
import java.util.Optional;

public class ParallelSorting {

    public interface ArrayOperations{
        void printArray(Integer[] array);
    }


    public static void printArray(Integer[] values){
        ArrayOperations arrayOperations= ( numbers)-> {
            Optional<Integer[]> arrayValues= Optional.ofNullable(numbers);
            arrayValues.ifPresent(finalValues -> Arrays.stream(finalValues).forEach(val-> System.out.print(val+ " ")));
        };
        arrayOperations.printArray(values);
    }

    /**
     * Parallel sorting using java8 Arrays.parallelSort method
     * @param values
     * @return
     */
    private static Integer[] parallelSortArray(Integer[] values){
        Arrays.parallelSort(values);
        return values;
    }



    public static void main(String[] args) {
        Integer[] values = new Integer[]{2,4,5,13,7,35,12};
        ParallelSorting.parallelSortArray(values);
        printArray(values);
    }
}
