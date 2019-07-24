package problems.interviewbit.strings_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthOfLastWord {


    //Solution approach using patterns
    public int lengthOfLastWord(final String A) {
        String str= new String(A.replaceAll(" $",""));
        Pattern p = Pattern.compile("(\\w+)$");
        Matcher m = p.matcher(str.trim());
        if(m.matches()){
            return m.group().length();
        }
        return -1;
    }

    public int lengthOfLastWordWithoutLibrary(final String s) {
        int len = 0;

        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        for (i=i; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                return len;
            }
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello world "));
    }
}
