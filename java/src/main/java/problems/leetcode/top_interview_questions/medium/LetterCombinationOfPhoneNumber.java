package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {


    char[][] digit = {{'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'},
            {'j', 'k', 'l'},{'m', 'n', 'o'},{'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},{'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        getCombinations(digits, 0, "", res);
        return res;
    }
    void getCombinations(String digits, int index, String curr, List<String> res) {
        if(index==digits.length()) {
            res.add(curr);
            return;
        }
        int num = digits.charAt(index)-'2';
        for(int i = 0; i<digit[num].length; i++)
            getCombinations(digits, index+1, curr+digit[num][i], res);
    }
}
