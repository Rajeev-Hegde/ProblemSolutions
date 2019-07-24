package problems.interviewbit.strings_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> A) {
        String str = A.get(0);
        StringBuilder subString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean continueAdding=true;
            for (int j = 1; j < A.size(); j++) {
                if (A.get(j).length()<= i || str.charAt(i)!= A.get(j).charAt(i)) {
                    continueAdding = false;
                    break;
                }
            }
            if (continueAdding){
                subString.append(str.charAt(i));
            }
            else
                break;
        }
        return subString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix()
                .longestCommonPrefix(new ArrayList<>(Arrays.asList("abab", "ab","abcd"))));
    }
}
