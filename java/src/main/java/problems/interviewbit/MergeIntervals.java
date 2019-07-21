package problems.interviewbit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
            } else {
                int start = Math.min(newInterval.start, interval.start);
                int end = Math.max(newInterval.end, interval.end);
                newInterval.start = start;
                newInterval.end = end;
            }
        }

        result.add(newInterval);

        return result;
    }
    public static void main(String[] args) {
        MergeIntervals mergeIntervals= new MergeIntervals();
        ArrayList<Interval> intervalArrayList = new ArrayList<>();
//        intervalArrayList.add(new Interval(1,2));
//        intervalArrayList.add(new Interval(3,5));
//        intervalArrayList.add(new Interval(6,7));
//        intervalArrayList.add(new Interval(8,10));
//        intervalArrayList.add(new Interval(12,16));
        intervalArrayList.add(new Interval(1,2));
        intervalArrayList.add(new Interval(8,10));
        System.out.println(mergeIntervals.insert(intervalArrayList, new Interval(3,6)));
    }
}
