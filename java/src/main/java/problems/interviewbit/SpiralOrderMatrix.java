package problems.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {


    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        // Populate result;
        int m, n;

        m = A.size();
        n = A.get(0).size();

        if (m == 0)
            return result;

        int len;
        int dir = 0; // right
        int row, col, layer;
        row = col = layer = 0;

        result.add(A.get(0).get(0));


        for (int step = 1; step < m * n; step++) {

            switch(dir) {

                // Go right
                case 0:

                    if (col == n - layer - 1) {
                        dir = 1;
                        row++;
                    } else {
                        col++;
                    }

                    break;

                // Go down
                case 1:

                    if (row == m - layer - 1) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }

                    break;

                // Go left
                case 2:

                    if (col == layer) {
                        dir = 3;
                        row--;
                    } else {
                        col--;
                    }

                    break;

                // Go up
                case 3:

                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else {
                        row--;
                    }

                    break;

            }

            //System.out.println(row + " " + col);
            result.add(A.get(row).get(col));

        }

        return result;
    }

    public static void main(String[] args) {

    }
}



//GO language solution

/*
 func spiralOrder(A [][]int) []int {
	var result = []int{}
	m := len(A)
	n := len(A[0])
	t := 0
	r := n - 1
	b := m - 1
	l := 0
	dir := 0

	for t <= b && l <= r {
		if dir == 0 {
			for i := l; i <= r; i++ {
				result = append(result, A[t][i])
			}
			t++
		}
		if dir == 1 {
			for i := t; i <= b; i++ {
				result = append(result, A[i][r])

			}
			r--
		}
		if dir == 2 {
			for i := r; i >= l; i-- {
				result = append(result, A[b][i])
			}
			b--
		}
		if dir == 3 {
			for i := b; i >= t; i-- {
				result = append(result, A[i][l])

			}
			l++
		}
		dir = (dir + 1) % 4
	}
	return result
}
 */