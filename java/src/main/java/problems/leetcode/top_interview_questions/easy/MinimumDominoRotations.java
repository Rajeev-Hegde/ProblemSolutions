package problems.leetcode.top_interview_questions.easy;

public class MinimumDominoRotations {

    public int minDominoRotations(int[] A, int[] B) {

        int rotationCount=getMinRotations(A[0],A,B);
        if(rotationCount!=-1|| A[0]== B[0]) return rotationCount;

        return  getMinRotations(B[0], A, B);
    }

    public int getMinRotations(int x, int[]A, int[] B){
        int rotateACount=0, rotateBCount=0;
        for(int i=0; i< A.length; i++){
            if(A[i]!=x && B[i]!=x) return -1;
            else if(A[i]!=x) rotateACount++;
            else if(B[i]!=x) rotateBCount++;
        }
        return Math.min(rotateACount, rotateBCount);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDominoRotations().minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
    }
}
