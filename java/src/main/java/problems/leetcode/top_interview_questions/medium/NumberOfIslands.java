package problems.leetcode.top_interview_questions.medium;

/**
 * IMPORTANT
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 */
public class NumberOfIslands {
    int rowLen, colLen;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;
        int[][] visitedNodes = new int[rowLen][colLen];
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visitedNodes[i][j] == 0 && grid[i][j]=='1') {
                    numIslands(grid, visitedNodes, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }


    public void numIslands(char[][] grid, int[][] visitedNodes, int i, int j) {
        if (i < rowLen && i>=0 && j < colLen && j>=0) {
            if(grid[i][j] == '1' && visitedNodes[i][j] == 0){
                visitedNodes[i][j] = 1;
                numIslands(grid, visitedNodes, i, j + 1);
                numIslands(grid, visitedNodes, i + 1, j);
                numIslands(grid, visitedNodes, i, j-1);
                numIslands(grid, visitedNodes, i-1, j);
            }
            else if(grid[i][j] == '0')
                visitedNodes[i][j] = 1;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
