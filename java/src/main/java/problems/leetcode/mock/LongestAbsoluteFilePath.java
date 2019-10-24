package problems.leetcode.mock;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    public int lengthLongestPathFast(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
        //System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        //System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("a\naa\n\taaa\n\t\tfile1.txt\n\taaaaaaaaaaaaaaaaaaaaa\n\t\tsth.png"));
    }
}
