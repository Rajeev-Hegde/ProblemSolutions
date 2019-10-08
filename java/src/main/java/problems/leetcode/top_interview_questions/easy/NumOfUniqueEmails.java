package problems.leetcode.top_interview_questions.easy;

import java.util.HashSet;
import java.util.Set;

public class NumOfUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email: emails){
            uniqueEmails.add(email.substring(0,email.indexOf('@'))
                    .replaceAll("\\.","")
                    .replaceAll("\\+[^@]*","")+email.substring(email.indexOf('@')));
        }
        return uniqueEmails.size();

    }
}
