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

    public int numUniqueEmailsSolution2(String[] emails) {
        int counter = 0;
        Set<String> emailSet = new HashSet<>();
        for (String s : emails) {
            int index = -1;
            StringBuilder sb = new StringBuilder();

            while (s.charAt(++index) != '@') {
                if (s.charAt(index) == '.') continue;
                else if (s.charAt(index) == '+') break;
                else sb.append(s.charAt(index));
            }

            if (emailSet.add(sb.append('@').toString() + s.substring(s.indexOf('@') + 1))) counter++;
        }

        return counter;
    }
}
