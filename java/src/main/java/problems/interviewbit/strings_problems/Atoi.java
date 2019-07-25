package problems.interviewbit.strings_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

    public int atoi(final String A) {

        String res = A.replaceAll("^ *","");
        Pattern pattern = Pattern.compile("^-?\\+?[0-9]+");
        Matcher matcher = pattern.matcher(res);
        while (matcher.find()){
            String group = matcher.group();
            if (group.equals(""))
                return 0;
            try {
                return Integer.valueOf(group);
            } catch (Exception e) {
                if (group.charAt(0) == '-')
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Atoi().atoi("7 U 0 T7165 0128862 089 39 5"));
    }
}
