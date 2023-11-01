class Main036 {
    public static void main(String[] args) {
        Solution036 solution = new Solution036();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board));
        board = new char[][] {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board));
    }
}

class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        // 用于存储每一行的数字
        boolean[][] row = new boolean[9][9];
        // 用于存储每一列的数字
        boolean[][] col = new boolean[9][9];
        // 用于存储每一个3x3的数字
        boolean[][] box = new boolean[9][9];
        // 遍历数独
        for (int i = 0; i < 9; i++) {
            // 遍历行
            for (int j = 0; j < 9; j++) {
                // 如果当前位置是数字
                if (board[i][j] != '.') {
                    // 计算当前数字在第几个3x3中
                    int boxIndex = (i / 3) * 3 + j / 3;
                    // 计算当前数字在第几行
                    int rowIndex = i;
                    // 计算当前数字在第几列
                    int colIndex = j;
                    // 如果当前数字在行、列、3x3中都已经出现过了，那么就不是有效的数独
                    if (row[rowIndex][board[i][j] - '1'] || col[colIndex][board[i][j] - '1'] || box[boxIndex][board[i][j] - '1']) {
                        return false;
                    }
                    // 否则，将当前数字在行、列、3x3中出现的情况记录下来
                    row[rowIndex][board[i][j] - '1'] = true;
                    col[colIndex][board[i][j] - '1'] = true;
                    box[boxIndex][board[i][j] - '1'] = true;
                }
            }
        }
        return true;
    }
}