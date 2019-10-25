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


    // -------------------- Solution 2 -------------------------

    // mark visited nodes as 0 in grid cell itself instead of maintaining separate array.
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslandsFasterApproach(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new NumberOfIslands().numIslandsFasterApproach(grid));
    }
}
