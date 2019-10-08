package problems.leetcode.top_interview_questions.easy;

public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder res= new StringBuilder();
        for(char ch: str.toCharArray()){
            if(!(ch <= 90 && ch>= 65 || ch <=122 && ch >= 97))
                res.append(String.valueOf(ch));
            else if(ch - 'A' <= 25)
                res.append(String.valueOf((char) ('a' + ch - 'A')));
            else
                res.append(String.valueOf(ch));
        }
        return res.toString();
    }
}
