package problems.leetcode.top_interview_questions.hard;

/**
 *  IMPORTANT PROBLEM
 *

 You may recall that an array A is a mountain array if and only if:

 A.length >= 3
 There exists some i with 0 < i < A.length - 1 such that:
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[A.length - 1]
 Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

 You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

 MountainArray.get(k) returns the element of the array at index k (0-indexed).
 MountainArray.length() returns the length of the array.
 */
public class FindMinInMountainArray {

    interface MountainArray {
        int get(int index);
        int length();
    }


    public int findInMountainArray(int target, MountainArray a) {
        int peek = findPeek(a);
        if (a.get(peek) < target) return -1;
        int l = bs1(a, target, peek);
        return l == -1 ? bs2(a, target, peek) : l;
    }

    private int findPeek(MountainArray a) {
        int l = 0, r = a.length() - 1;
        while (l < r) {
            int m1 = (l + r) / 2;
            int m2 = m1 + 1;
            if (a.get(m1) < a.get(m2)) {
                l = m2;
            } else {
                r = m1;
            }
        }
        return l;
    }

    private int bs1(MountainArray a, int target, int peek) {
        int l = 0, r = peek;
        while (l <= r) {
            int m = (l + r) / 2;
            int v = a.get(m);
            if (v > target) {
                r = m - 1;
            } else if (v < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return a.get(l) == target ? l : -1;
    }

    private int bs2(MountainArray a, int target, int peek) {
        int l = peek, r = a.length() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int v = a.get(m);
            if (v < target) {
                r = m - 1;
            } else if (v > target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l < a.length() && a.get(l) == target ? l : -1;
    }
}
