class Main289 {
    public static void main(String[] args) {
        Solution289 s = new Solution289();
        int[][] board = new int[][]{
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        s.gameOfLife(board);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

class Solution289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int s = getNeighbor(board, x, y);
                if (board[y][x] == 1) {
                    if (s < 2 || s > 3) {
                        board[y][x] = 2; // alive -> die
                    }
                } else if (s == 3) {
                    board[y][x] = 3; // die -> alive
                }
            }
        }
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                switch (board[y][x]) {
                    case 2:
                        board[y][x] = 0;
                        break;
                    case 3:
                        board[y][x] = 1;
                        break;
                }
            }
        }

    }

    private int getNeighbor(int[][] board, int x, int y) {
        System.out.println("(" + x + "," + y + "):");
        int aliveNeighborCnt = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                System.out.println("    checking (" + (x+dx) + "," + (y+dy) + ")");
                for (int[] row : board) {
                    for (int cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
                if (x+dx >= 0 && x+dx < board[0].length
                        && y+dy >= 0 && y+dy < board.length
                        && board[y+dy][x+dx] == 1) {
                    System.out.println("    found (" + (x+dx) + "," + (y+dy) + ")");
                    aliveNeighborCnt++;
                }
            }
        }
        return aliveNeighborCnt - board[y][x];
    }
}