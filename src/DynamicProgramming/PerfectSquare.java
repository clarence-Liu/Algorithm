package DynamicProgramming;

import java.util.Scanner;

/**
 * 279. 完全平方数
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
/*
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

public class PerfectSquare {
    public static void main(String[] args){
        System.out.println("Give the number n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = numSquares(n);
        System.out.println("res = " + res);
    }
    public static int numSquares(int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <=n; ++i) {
            int temp = (int) Math.sqrt(i);
            int min = i;
            for (int j = temp; j >= 1; --j) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
