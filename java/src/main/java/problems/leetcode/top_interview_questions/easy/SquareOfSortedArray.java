package problems.leetcode.top_interview_questions.easy;

public class SquareOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = res.length-1, left = 0, right = A.length-1;
        while(left <= right){
            if(A[left]*A[left] > A[right]*A[right]){
                res[i--] = A[left]*A[left];
                left++;
            }else{
                res[i--] = A[right]*A[right];
                right--;
            }
        }
        return res;
    }
}
