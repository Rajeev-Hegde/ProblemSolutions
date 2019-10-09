package problems.leetcode.top_interview_questions.easy;

public class DesignHashMap {
    private int[] table;

    public DesignHashMap() {
        table = new int[1000001];
    }

    public void put(int key, int value) {
        table[key] = value+1;
    }

    public int get(int key) {
        return table[key]-1;
    }

    public void remove(int key) {
        table[key]=0;
    }
}
