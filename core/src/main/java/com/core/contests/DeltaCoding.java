package com.core.contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DeltaCoding {


    public static List<Integer> delta_encode(List<Integer> numbers) {
        // Write your code here
        List<Integer> out = new LinkedList<>();
        out.add(numbers.get(0));
        for (int i=1;i < numbers.size(); i++){
            Integer diff = numbers.get(i)- numbers.get(i-1);
            if(!(diff >= -127 && diff <= 127)){
                out.add(-128);
                out.add(numbers.get(i));
            }
            else
                out.add(diff);
        }
        return out;
    }


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(25626,131,-1390,-100,-24251,84,-98,7275);
        new DeltaCoding().delta_encode(array);
    }


}
