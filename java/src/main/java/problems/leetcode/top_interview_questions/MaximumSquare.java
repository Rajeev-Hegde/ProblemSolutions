package problems.leetcode.top_interview_questions;

public class MaximumSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;

        int[][] mem = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            mem[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));


        for(int j = 0; j < matrix[0].length; j++)
            mem[0][j] = Integer.parseInt(String.valueOf(matrix[0][j]));

        for(int i=1; i< matrix.length; i++){
            for(int j=1; j< matrix[0].length; j++){
                if(matrix[i][j] =='1'){
                    mem[i][j]= Math.min(mem[i][j-1],Math.min( mem[i-1][j], mem[i-1][j-1])) + 1;
                }
                else
                    mem[i][j]=0;
            }
        }
        int max=0;;
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(max< mem[i][j]){
                    max= mem[i][j];
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximumSquare().maximalSquare(matrix));
    }
}
