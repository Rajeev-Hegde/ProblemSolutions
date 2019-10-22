package problems.leetcode.top_interview_questions.easy;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        if(n==1) return "A";
        n=n-1;
        while(n>=0){
            char ch= (char) ((int)'A'+ ((n)%26));
            sb.append(ch);
            n=n/26-1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(703));
    }
}
