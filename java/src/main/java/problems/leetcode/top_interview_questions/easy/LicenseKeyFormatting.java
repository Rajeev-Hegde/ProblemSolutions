package problems.leetcode.top_interview_questions.easy;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        int counter = 0;
        StringBuilder res = new StringBuilder();
        for(int i=S.length()-1; i>=0; i--){
            if(S.charAt(i)!='-'){
                if(counter==K){
                    res.insert(0, "-");
                    counter=0;
                }
                char ch = 'a'<= S.charAt(i) && S.charAt(i)<= 'z'? (char)(S.charAt(i)-32): S.charAt(i);
                res.insert(0, ch);
                counter++;
            }
        }
        return res.toString();
    }

    public String licenseKeyFormattingFaster(String S, int K) {
        int counter = 0;
        StringBuilder res = new StringBuilder();
        for(int i=S.length()-1; i>=0; i--){
            if(S.charAt(i)!='-'){
                if(counter==K){
                    res.append("-");
                    counter=0;
                }
                char ch = Character.toUpperCase(S.charAt(i));
                res.append(ch);
                counter++;
            }
        }
        return res.reverse().toString();
    }
}
