package BackTracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 488. Zuma Game
 * <p>You are playing a variation of the game Zuma.
 *
 * <p>In this variation of Zuma, there is a <strong>single row</strong> of colored balls on a board,
 * where each ball can be colored red '{@code R}', yellow '{@code Y}', blue '{@code B}', green '{@code G}', or white '{@code W}'.
 * You also have several colored balls in your hand.
 *
 * <p>Your goal is to clear all of the balls from the board. On each turn:
 *      <p>Pick any ball from your hand and insert it in between two balls in the row or on either end of the row.
 *      <p>If there is a group of three or more consecutive balls of the same color, remove the group of balls from the board.
 *      <p>If this removal causes more groups of three or more of the same color to form, then continue removing each group until there are none left.
 *      <p>If there are no more balls on the board, then you win the game.
 *      <p>Repeat this process until you either win or do not have any more balls in your hand.
 *
 * <p>Given a string {@code board}, representing the row of balls on the board, and a string {@code hand},
 * representing the balls in your hand, return the <strong>minimum</strong> <i>number of balls you have to insert to clear all the balls from the board.
 * If you cannot clear all the balls from the board using the balls in your hand, return</i> {@code -1}.
 *
 * <p>Constraints:
 *      <p>1 <= board.length <= 16
 *      <p>1 <= hand.length <= 5
 *      <p>board and hand consist of the characters '{@code R}', '{@code Y}', '{@code B}', '{@code G}', and '{@code W}'.
 *      <p>The initial row of balls on the board will <strong>not</strong> have any groups of three or more consecutive balls of the same color.
 */


/*
Example 1:
Input: board = "WRRBBW", hand = "RB"
Output: -1
Explanation: It is impossible to clear all the balls. The best you can do is:
- Insert 'R' so the board becomes WRRRBBW. WRRRBBW -> WBBW.
- Insert 'B' so the board becomes WBBBW. WBBBW -> WW.
There are still balls remaining on the board, and you are out of balls to insert.

Example 2:
Input: board = "WWRRBBWW", hand = "WRBRW"
Output: 2
Explanation: To make the board empty:
- Insert 'R' so the board becomes WWRRRBBWW. WWRRRBBWW -> WWBBWW.
- Insert 'B' so the board becomes WWBBBWW. WWBBBWW -> WWWW -> empty.
2 balls from your hand were needed to clear the board.

Example 3:
Input: board = "G", hand = "GGGGG"
Output: 2
Explanation: To make the board empty:
- Insert 'G' so the board becomes GG.
- Insert 'G' so the board becomes GGG. GGG -> empty.
2 balls from your hand were needed to clear the board.

Example 4:
Input: board = "RBYYBBRRB", hand = "YRBGB"
Output: 3
Explanation: To make the board empty:
- Insert 'Y' so the board becomes RBYYYBBRRB. RBYYYBBRRB -> RBBBRRB -> RRRB -> B.
- Insert 'B' so the board becomes BB.
- Insert 'B' so the board becomes BBB. BBB -> empty.
3 balls from your hand were needed to clear the board.

Example 5:
Input: board = "WWRRBBWW", hand = "WRBRW"
Output: 2

"BGGRRYY"
"BBYRG"
-1

 */
public class ZumaGame {

    private Map<String, Integer> map;

    public int findMinStep(String board, String hand) {
        this.map = new HashMap<>();
        int res = dfs(board, hand,1 << hand.length());
        return res == 0x3f3f3f3f ? -1 : res;
    }

    private int dfs (String board, String hand, int cur) {
        if (board.length() <= 0) return 0;
        if (map.containsKey(board)) return map.get(board);
        int res = 0x3f3f3f3f;
        int n = board.length();
        for (int i = 0; i < hand.length(); i++) {
            if (((cur >> i) & 1) == 1) continue;
            int next = (1 << i) | cur;
            for (int j = 0; j <= n; j++) {
                if (j > 0 && j < n - 1 && board.charAt(j) == board.charAt(j - 1)) continue;
                if (j > 0 && j < n - 1 && board.charAt(j) == hand.charAt(i)) continue;
                StringBuilder newBoard = new StringBuilder();
                newBoard.append(board, 0, j)
                        .append(hand.charAt(i));
                if (j != n) {
                    newBoard.append(board, j,n);
                }
                int k = j;
                while (0 <= k && k < newBoard.length()){
                    char c = newBoard.charAt(k);
                    int left = k, right = k;
                    while (0 <= left && newBoard.charAt(left) == c) --left;
                    while (right < newBoard.length() && newBoard.charAt(right) == c) ++right;
                    if (right - left - 1 >= 3) {
                        newBoard.delete(left + 1, right);
                        k = left >= 0 ? left : right;
                    } else {
                        break;
                    }
                }
                res = Math.min(res, dfs(newBoard.toString(), hand, next) + 1);
            }
        }
        map.put(board, res);
        return res;
    }


//    public int findMinStep(String board, String hand) {
//        int boardLength = board.length(), handLength = hand.length();
//        if (boardLength <= 0) {
//            return 0;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < handLength; i++) {
//            for (int j = 0; j < boardLength; j++) {
//                String newBoard = board.substring(0, j) + hand.charAt(i) + board.substring(j);
//                newBoard = eliminate(newBoard);
//                int r = findMinStep(newBoard, hand.substring(0, i) + hand.substring(i + 1));
//                if (r != -1) {
//                    res = Math.min(res, r + 1);
//                }
//            }
//        }
//        return res < Integer.MAX_VALUE ? res : -1;
//    }
//    private String eliminate (String board) {
//        int length = board.length();
//        int s = 0;
//        for (int i = 1; i <= length; i++) {
//            if (i == length||board.charAt(i - 1) != board.charAt(i)) {
//                if (i - s >= 3) {
//                    return eliminate(board.substring(0, s) + board.substring(i, length));
//                } else {
//                    s = i;
//                }
//            }
//        }
//        return board;
//    }
}
