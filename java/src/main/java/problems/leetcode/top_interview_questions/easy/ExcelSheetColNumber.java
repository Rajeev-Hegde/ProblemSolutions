package problems.leetcode.top_interview_questions.easy;

public class ExcelSheetColNumber {
    public int titleToNumber(String s) {
        if (s == null)
            return 0;
        int number = 0;
        for (char c : s.toCharArray())
            number = number * 26 + getValue(c);
        return number;
    }

    private int getValue(char c) {
        return c - 'A' + 1;
    }
}
