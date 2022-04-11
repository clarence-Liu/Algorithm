package Incomplete;

import java.util.Arrays;

/**
 * 375. Guess Number Higher or Lower II
 * <p>We are playing the Guessing Game. The game will work as follows:
 * <ol>
 *     <li>I pick a number between <tt>1</tt> and <tt>n</tt>.</li>
 *     <li>You guess a number.</li>
 *     <li>If you guess the right number, <strong>you win the game</strong>.</li>
 *     <li>If you guess the wrong number, then I will tell you whether the number I picked is <strong>higher or lower</strong>, and you will continue guessing.</li>
 *     <li>Every time you guess a wrong number <tt>x</tt>, you will pay <tt>x</tt> dollars. If you run out of money, <strong>you lose the game</strong>.</li>
 * </ol>
 * Given a particular <tt>n</tt>, return the minimum amount of money you need to <strong>guarantee a win regardless of what number I pick</strong>.
 * <p>Constraints:
 * <li><tt>i<=n<=200</tt></li>
 */
/*
Input: n = 10
Output: 16
Explanation: The winning strategy is as follows:
- The range is [1,10]. Guess 7.
    - If this is my number, your total is $0. Otherwise, you pay $7.
    - If my number is higher, the range is [8,10]. Guess 9.
        - If this is my number, your total is $7. Otherwise, you pay $9.
        - If my number is higher, it must be 10. Guess 10. Your total is $7 + $9 = $16.
        - If my number is lower, it must be 8. Guess 8. Your total is $7 + $9 = $16.
    - If my number is lower, the range is [1,6]. Guess 3.
        - If this is my number, your total is $7. Otherwise, you pay $3.
        - If my number is higher, the range is [4,6]. Guess 5.
            - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $5.
            - If my number is higher, it must be 6. Guess 6. Your total is $7 + $3 + $5 = $15.
            - If my number is lower, it must be 4. Guess 4. Your total is $7 + $3 + $5 = $15.
        - If my number is lower, the range is [1,2]. Guess 1.
            - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $1.
            - If my number is higher, it must be 2. Guess 2. Your total is $7 + $3 + $1 = $11.
The worst case in all these scenarios is that you pay $16. Hence, you only need $16 to guarantee a win.

Example 2:
Input: n = 1
Output: 0
Explanation: There is only one possible number, so you can guess 1 and not have to pay anything.

Example 3:
Input: n = 2
Output: 1
Explanation: There are two possible numbers, 1 and 2.
- Guess 1.
    - If this is my number, your total is $0. Otherwise, you pay $1.
    - If my number is higher, it must be 2. Guess 2. Your total is $1.
The worst case is that you pay $1.
 */
public class GuessNumber {
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] costs = new int[n + 1][n + 1];
//        for (int i = n; i < ; i++) {
//
//        }

        return 0;
    }
}
