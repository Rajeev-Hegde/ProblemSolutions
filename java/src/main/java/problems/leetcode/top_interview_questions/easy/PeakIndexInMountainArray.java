package problems.leetcode.top_interview_questions.easy;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        for(int i=1; i< A.length-1; i++){
            if(A[i]> A[i+1] && A[i]> A[i-1])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0};
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(array));
    }
}
