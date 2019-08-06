package concepts.java8_features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class FunctionInterfaceUsage {


    private static Integer calculateMaxInArray(Integer[] numbers){
        return Arrays.stream(numbers).max(Comparator.naturalOrder()).get();
    }

    private static Integer calculateMinInArray(Integer[] numbers){
        return Arrays.stream(numbers).min(Comparator.naturalOrder()).get();
    }

    private static Integer[] removeMinusOne(Integer[] numbers){
        return Arrays.stream(numbers).filter(num-> num!=-1).toArray(Integer[]::new);
    }


    public static void main(String[] args) {

        Function<Integer[],Integer> functionMax = FunctionInterfaceUsage::calculateMaxInArray;
        Function<Integer[],Integer> functionMin = FunctionInterfaceUsage::calculateMinInArray;
        Function<Integer[],Integer[]> removeMinusOne = FunctionInterfaceUsage::removeMinusOne;
        System.out.println(functionMax.apply(new Integer[]{2,7,3,5,-1, -1}));

        //Removes -1 from array before finding out minimum value
        System.out.println(functionMin.compose(removeMinusOne).apply(new Integer[]{2,7,3,5,-1, -1}));

    }
}
