package problems.leetcode.top_interview_questions.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(intv -> intv[0]));
        for(int i=0; i< intervals.length; i++){
            if(i+1!=intervals.length && intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{5,8},{9,10},{9,12}};
        System.out.println(new MeetingRooms().canAttendMeetings(intervals));
    }
}
