package problems.leetcode.top_interview_questions.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a sequence of words, check whether it forms a valid word square.

 A sequence of words forms a valid word square if the kth row and column read the exact same string,
 where 0 ≤ k < max(numRows, numColumns).
 */
public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        Set<String> checkedLocations = new HashSet<>();
        for(int i=0; i< words.size(); i++){
            for(int j=0; j< words.get(i).length(); j++){
                // if(checkedLocations.contains(i+"_"+j))
                //     continue;
                if(j>= words.size() || i>= words.get(j).length() || words.get(j).charAt(i)!= words.get(i).charAt(j))
                    return false;
                // checkedLocations.add(j+"_"+i);
            }
        }
        return true;
    }
}
