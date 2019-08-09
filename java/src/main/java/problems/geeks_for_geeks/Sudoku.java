package problems.geeks_for_geeks;


import java.util.Scanner;

public class Sudoku
{

    public static boolean solveSudoku(int dp[][]){
        int row=-1,col=-1;
        boolean flag=false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                if(dp[i][j]==0){
                    row=i;col=j;flag=true;break;
                }
            if(flag) break;
        }
        if(!flag) return true;
        for(int i=1;i<=9;i++){
            if(isSafe(dp,row,col,i)){
                dp[row][col] = i;
                if(solveSudoku(dp)) return true;
                else   dp[row][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int dp[][], int row, int col, int value){
        for(int i=0;i<9;i++)
            if(dp[row][i]==value) return false;
        for(int i=0;i<9;i++)
            if(dp[i][col]==value) return false;
        int istart = row-row%3,jstart = col-col%3;
        for(int i=istart;i<istart+3;i++)
            for(int j=jstart;j<jstart+3;j++)
                if(dp[i][j]==value) return false;
        return true;
    }


    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int x=0;x<t;x++){
            int dp[][] = new int[9][9];
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    dp[i][j] = in.nextInt();
            if(solveSudoku(dp)){
                for(int i=0;i<9;i++)
                    for(int j=0;j<9;j++)
                        System.out.print(dp[i][j]+" ");
                System.out.println();
            }
            else
                System.out.println(-1);
        }
    }
}
