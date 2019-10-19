package problems.leetcode.top_interview_questions.easy;

public class ImplementstrStr {

    // ------------------------- Solution 1 ---------------------
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.equals("")) return 0;

        int k=0;
        while(k< haystack.length()){
            int i=k;
            int j=0;
            while(needle.charAt(j) == haystack.charAt(i)){
                i++;
                j++;
                if(j== needle.length()) return i-j;
                if(i>= haystack.length()) return -1;
            }
            k++;
        }

        return -1;
    }

    // ------------------------- Solution 2 ---------------------

    public int strStrEfficient(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for(int i = 0; i<=haystack.length()-needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
            }
        }
        return -1;
    }



    // --------------------------- Solution 3 ----------------------

    private int[] computeLPS(String str) { // computes Longest Prefix Suffix (LPS) array
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int i = 1; // always walks forward
        int j = 0; // tracks prefix that matches suffix

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else { // mismatch
                if (j == 0) { // go onto next character in string
                    lps[i] = 0;
                    i++;
                } else { // backtrack j to check previous matching prefix
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }

    int strStrUsingKMP(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        }

        int[] lps = computeLPS(needle);
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // match found. Return location of match
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1]; // backtrack j to check previous matching prefix
                }
            }
        }

        return -1; // did not find needle
    }


    public static void main(String[] args) {
        System.out.println(new ImplementstrStr().strStr("mississippi","issip"));
    }
}
