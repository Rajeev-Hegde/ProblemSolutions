package problems.leetcode.top_interview_questions.hard;

public class RegularExpressionMatching {

//    public boolean isMatch(String s, String p) {
//        int k=0, i=0;
//        while(k< s.length() && i< p.length()){
//            char ch= p.charAt(i);
//            if(ch == '.' && i+1 <p.length() &&  p.charAt(i+1)== '*') {
//                k = s.length();
//                i+=2;
//            }
//            else if(ch == '.') {
//                k++;
//                i++;
//            }
//            else if(i+1 <p.length() && p.charAt(i+1)== '*'){
//                while(k<s.length() && s.charAt(k)== ch)
//                    k++;
//                i+=2;
//                while(i< p.length() && p.charAt(i)== ch)
//                    i++;
//            }
//            else{
//                if( p.charAt(i)!= s.charAt(k))
//                    return false;
//                k++;
//                i++;
//            }
//        }
//        if(k< s.length() || i< p.length())
//            return false;
//        return true;
//    }

    //TODO:: understand this solution
    public boolean isMatch(String s, String p) {
        if (s != null && s.equals(p)) return true;
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        int ls = ss.length, lp = ps.length;
        boolean[][] dp = new boolean[lp + 1][ls + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lp; i++)
            dp[i][0] = i > 1 && ps[i - 1] == '*' && dp[i - 2][0];
        for (int i = 1; i <= lp; i++) {
            if (ps[i - 1] == '*') {
                for (int j = 1; j <= ls; j++) {
                    dp[i][j] = (i > 1 && dp[i - 2][j]) || (dp[i][j - 1] && (ps[i - 2] == '.' || ps[i - 2] == ss[j - 1]));
                }
            } else {
                for (int j = 1; j <= ls; j++)
                    dp[i][j] = dp[i - 1][j - 1] && (ps[i - 1] == '.' || ps[i - 1] == ss[j - 1]);
            }
        }
        return dp[lp][ls];
    }

    public static void main(String[] args) {

        System.out.println(new RegularExpressionMatching().isMatch("aaa","a*a"));
    }
}
