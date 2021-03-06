package problems.leetcode.contest;

import java.util.Vector;


/**
 * Slight modified version of knight problem where knight is assumed to be at center of board and
 */
public class MinimumKnightMoves {

    static class cell
    {
        int x, y;
        int dis;

        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }


    }

    static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    public int minKnightMoves(int x, int y) {
        return minStepToReachTarget(new int[]{150,150}, new int[]{Math.abs(x)+150,Math.abs(y)+150},900);
    }

    static int minStepToReachTarget(int knightPos[], int targetPos[],
                                    int N)
    {

        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        Vector<cell> q = new Vector<>();

        q.add(new cell(knightPos[0], knightPos[1], 0));

        cell t ;
        int x, y;
        boolean visit[][] = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        visit[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty())
        {
            t = q.firstElement();
            q.remove(0);

            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            for (int i = 0; i < 8; i++)
            {
                x = t.x + dx[i];
                y = t.y + dy[i];

                if (isInside(x, y, N) && !visit[x][y])
                {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumKnightMoves().minKnightMoves(2,1));
    }
}
