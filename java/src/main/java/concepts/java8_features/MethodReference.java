package concepts.java8_features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

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

    public static void main(String[] args) {
        Print print= MethodReference::staticWelcomeMessage;
        print.print("Hello world from static method");


        Print print1 = new MethodReference()::welcomeMessage;
        print1.print("Hello world from object method");


        Function<Integer[],Integer> function = MethodReference::calculateMaxInArray;
        System.out.println(function.apply(new Integer[]{2,7,3,5}));

    }
}
