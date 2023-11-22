import java.util.ArrayList;
import java.util.List;

class Main073 {
    public static void main(String[] args) {
        Solution073 solution = new Solution073();
        int[][] matrix = new int[][] {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };
        solution.setZeroes(matrix);
        System.out.println(matrix);
    }
}

class Solution073 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> colsToSetZero = new ArrayList<Integer>();
        for (int y = 0; y < m; y++) {
            boolean rowSetZero = false;
            for (int x = 0; x < n; x++) {

                if (matrix[y][x] == 0) {
                    rowSetZero = true;
                    if (!colsToSetZero.contains(x)) {
                        colsToSetZero.add(x);
                    }
                }
            }
            if (rowSetZero == true) {
                for (int x = 0; x < n; x++) {
                    matrix[y][x] = 0;
                }
            }
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (colsToSetZero.contains(x)) {
                    matrix[y][x] = 0;
                }
            }
        }
    }
}