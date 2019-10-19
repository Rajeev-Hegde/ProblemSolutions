package problems.leetcode.top_interview_questions.easy;

public class ValidPalindromeSentence {

    public boolean isPalindrome(String s) {
        int i=0, j= s.length()-1;
        if(s.length()==0) return true;
        while(i< j){
            char frontChar = Character.toLowerCase(s.charAt(i));
            char backChar = Character.toLowerCase(s.charAt(j));
            if((('a'<= frontChar && 'z'>= frontChar) ||
                    '0'<= frontChar && '9'>= frontChar) && (('a'<= backChar && 'z'>= backChar) || '0'<= backChar && '9'>= backChar)){
                if(frontChar!= backChar) return false;
                i++;
                j--;
            }
            else{
                if(!(('a'<= frontChar && 'z'>= frontChar)|| '0'<= frontChar && '9'>= frontChar) )
                    i++;
                if(!(('a'<= backChar && 'z'>= backChar)|| '0'<= backChar && '9'>= backChar) )
                    j--;
            }
        }
        return i>=j;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeSentence().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
