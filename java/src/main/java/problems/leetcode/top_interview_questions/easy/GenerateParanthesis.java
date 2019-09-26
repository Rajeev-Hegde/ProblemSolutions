package problems.leetcode.top_interview_questions.easy;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParanthesis(n,res, "",0,0);
        return res;
    }

    public void generateParanthesis(int n, List<String> res,String str,int openParanthesisUsed,
                                    int closedParantheisUsed){
        if(openParanthesisUsed+closedParantheisUsed == 2*n){
            res.add(str);
            return;
        }
        if(openParanthesisUsed< n)
            generateParanthesis(n,res,str+"(", openParanthesisUsed+1, closedParantheisUsed);
        if(openParanthesisUsed<= n && openParanthesisUsed > closedParantheisUsed)
            generateParanthesis(n,res,str+")", openParanthesisUsed, closedParantheisUsed+1);
        return;
    }
}
