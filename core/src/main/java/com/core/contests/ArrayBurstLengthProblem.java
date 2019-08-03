package com.core.contests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayBurstLengthProblem {

    static List<String> shrink(List<String> inputArray, int burstLength) {
        if (inputArray == null || inputArray.size() == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        String charToCompare = inputArray.get(0);
        int currentCharacterOccurrenceCount = 1;
        for (int i = 1; i < inputArray.size(); i++) {
            if (inputArray.get(i).equals(charToCompare))
                currentCharacterOccurrenceCount++;
            else {
                if (currentCharacterOccurrenceCount < burstLength) {
                    addToResult(result,charToCompare,currentCharacterOccurrenceCount);
                }

                charToCompare = inputArray.get(i);
                currentCharacterOccurrenceCount = 1;
            }


        }
        if (currentCharacterOccurrenceCount < burstLength)
            addToResult(result,charToCompare,currentCharacterOccurrenceCount);
        return result;

    }

    static void addToResult(List<String> result,String characterString, int occurrenceCount){
        for (int i = 0; i < occurrenceCount; i++) {
            result.add(characterString);
        }
    }

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        List<String> result = inputArray;
        int currentResSize;
        do {
            currentResSize = result.size();
            result = shrink(result, burstLength);
        } while (result.size() != currentResSize);
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> inputArray = new ArrayList<>();
        inputArray.add("a");
        inputArray.add("b");
        inputArray.add("c");
        inputArray.add("c");
        inputArray.add("c");
        inputArray.add("b");
        inputArray.add("b");


        System.out.println(ArrayBurstLengthProblem.getShrunkArray(inputArray, 3));
    }
}
