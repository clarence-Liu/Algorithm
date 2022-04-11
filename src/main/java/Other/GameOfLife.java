package Other;

import Z_Entry.Print;

/**
 * 289. Game of Life
 * <p>According to Wikipedia's article: "The <strong>Game of Life</strong>, also known simply as <strong>Life</strong>, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * <p>The board is made up of an <tt>m x n</tt> grid of <tt>cells</tt>, where each cell has an initial state: <strong>live</strong> (represented by a 1) or <strong>dead</strong> (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <ol>
 *     <li>Any live cell with fewer than two live neighbors dies as if caused by under-population.</li>
 *     <li>Any live cell with two or three live neighbors lives on to the next generation.</li>
 *     <li>Any live cell with more than three live neighbors dies, as if by over-population.</li>
 *     <li>Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.</li>
 * </ol>
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 * <p>Constraints:
 * <ul>
 *     <li><tt>m == board.length</tt></li>
 *     <li><tt>n == board[i].length</tt></li>
 *     <li><tt>1 <= m, n <= 25</tt></li>
 *     <li><tt>board[i][j]</tt> is 0 or 1.</li>
 * </ul>
 */

/*
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 */
public class GameOfLife {

//    public void gameOfLife(int[][] board) {
//        int m = board.length, n = board[0].length;
//        int[] neighbors = {-1, 0 ,1};
//        for (int row = 0; row < m; row++) {
//            for (int col = 0; col < n; col++) {
//                int liveNeighbors = 0;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (!(neighbors[i] == 0 && neighbors[j] == 0) ) {
//                            int r = row + neighbors[i], c = col + neighbors[j];
//                            if ((0 <= r && r < m) && (0 <= c && c < n) && Math.abs(board[r][c]) == 1) {
//                                liveNeighbors += 1;
//                            }
//                        }
//                    }
//                }
//                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
//                    board[row][col] = -1;
//                }
//                if (board[row][col] == 0 && liveNeighbors == 3) {
//                    board[row][col] = 2;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = board[i][j] > 0 ? 1 : 0;
//            }
//        }
//        System.out.println(Print.print(board));
//    }
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] newBoard = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            System.arraycopy(board[i - 1], 0, newBoard[i], 1, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = newBoard[i][j] + newBoard[i][j + 1] + newBoard[i][j + 2] +
                        newBoard[i + 1][j] + newBoard[i + 1][j + 2] +
                        newBoard[i + 2][j] + newBoard[i + 2][j + 1] + newBoard[i + 2][j + 2];
                if (neighbors == 3) {
                    board[i][j] = 1;
                } else if (neighbors < 2 || neighbors > 3) {
                    board[i][j] = 0;
                }
            }
        }
        System.out.println(Print.print(board));
    }
}
