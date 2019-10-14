package problems.leetcode.top_interview_questions.easy;

public class StudentAttendanceRecord1 {

    public boolean checkRecord(String s) {
        int aCount = 0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)== 'A' ) {
                if (++aCount > 1)
                    return false;
            }
            else if(i+2<s.length() &&
                    s.charAt(i) == 'L' &&
                    s.charAt(i+1) == 'L' &&
                    s.charAt(i+2) == 'L'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new StudentAttendanceRecord1().checkRecord("PPALLL"));
    }
}
