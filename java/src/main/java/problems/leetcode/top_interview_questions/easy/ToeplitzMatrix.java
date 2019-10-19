package problems.leetcode.top_interview_questions.easy;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length==0)
            return true;
        int num = matrix[0][0];

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){

                if(i>0 && j> 0){
                    if(matrix[i-1][j-1]!= matrix[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}
