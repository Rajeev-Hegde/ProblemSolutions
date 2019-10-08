package problems.leetcode.top_interview_questions.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> queue;
    int size;
    Double sum = 0.0;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() < size) {
            queue.add(val);
            sum = sum + val;
        } else {
            int head = queue.remove();
            queue.add(val);
            sum = sum - head + val;
        }
        return sum/queue.size();
    }
}
