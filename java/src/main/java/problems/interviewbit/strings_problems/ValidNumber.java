package problems.interviewbit.strings_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {


    public int isNumber(final String A) {
        Pattern compile = Pattern.compile(" *[0-9]*(\\.[0-9][0-9]*)?([+-]?e[+-]?[0-9][0-9]*) *|" +
                " *[+-][0-9]+(\\.[0-9][0-9]*)?(e[+-]?[0-9][0-9]*)? *|" +
                " *[+-]?[0-9]+(\\.[0-9][0-9]*)?([+-]?e[+-]?[0-9][0-9]*)? *|" +
                " *[+-]?[0-9]*(\\.[0-9][0-9]*)([+-]?e[+-]?[0-9][0-9]*)? *");
        Matcher matcher = compile.matcher(A);
        if(matcher.matches())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("+ "));
    }
}
