package concepts.java8_features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReference {

    private void welcomeMessage(String a){
        System.out.println(a);
    }

    private static void staticWelcomeMessage(String a){
        System.out.println(a);
    }

    interface Print{
        void print(String a);
    }


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
        Print print= MethodReference::staticWelcomeMessage;
        print.print("Hello world from static method");


        Print print1 = new MethodReference()::welcomeMessage;
        print1.print("Hello world from object method");


        Function<Integer[],Integer> functionMax = MethodReference::calculateMaxInArray;
        Function<Integer[],Integer> functionMin = MethodReference::calculateMinInArray;
        Function<Integer[],Integer[]> removeMinusOne = MethodReference::removeMinusOne;
        System.out.println(functionMax.apply(new Integer[]{2,7,3,5,-1, -1}));

        //Removes -1 from array before finding out minimum value
        System.out.println(functionMin.compose(removeMinusOne).apply(new Integer[]{2,7,3,5,-1, -1}));

    }
}
