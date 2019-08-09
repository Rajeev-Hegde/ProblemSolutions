package problems.interviewbit.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestCommonSuperString {



    public int solve(ArrayList<String> A) {
        StringBuilder builder = new StringBuilder();
        A.parallelStream().forEach(builder::append);
        Set<Character> characters= new HashSet<>();
        for (Character ch: builder.toString().toCharArray()){
            characters.add(ch);
        }
        return characters.size();
    }

    public static void main(String[] args) {
        System.out.println(new ShortestCommonSuperString()
                .solve(new ArrayList<>(Arrays.asList(
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb",
                        "fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb"))));
    }
}
