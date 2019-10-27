package problems.leetcode.top_interview_questions.medium;

/**
 * IMPORTANT
 */
public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        if (source.equals(target)) return 1;
        int k = source.length();
        int n = target.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int base = i;
            int j = 0;
            while (j < k) {
                if (i < n && source.charAt(j) == target.charAt(i)) {
                    i++;
                }
                j++;
            }
            if (i == base) return -1;

            ans++;
        }
        return ans;
    }

}
