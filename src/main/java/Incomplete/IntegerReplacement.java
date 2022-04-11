package Incomplete;

/**
 * 397. Integer Replacement
 * <p>Given a positive integer <tt>n</tt>, you can apply one of the following operations:
 * <ol>
 *     <li>If <tt>n</tt> is even, replace <tt>n</tt> with <tt>n / 2</tt>.</li>
 *     <li>If <tt>n</tt> is odd, replace <tt>n</tt> with either <tt>n + 1</tt> or <tt>n - 1</tt>.</li>
 * </ol>
 * Return the minimum number of operations needed for n to become 1.
 *
 * <p>Constraints:
 * <li><tt>1 <= n <= 2^31 - 1</tt></li>
 */

/*
Example 1:
Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:
Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1

Example 3:
Input: n = 4
Output: 2
 */
public class IntegerReplacement {
    public static int integerReplacement(int n) {
        long num = n;
        int count = 0;
        while (num > 1) {
            if ((num & 1) == 1) {
                if ((num & 2) == 0 || (num == 3)) {
                    num -= 1;
                } else {
                    num += 1;
                }
                count++;
            }
            count++;
            num >>= 1;
        }
        return count;
//        int dp[] = new int[n + 1];
//        for (int i = 2; i <= n / 2 ; ++i) {
//            if(i % 2 == 0) {
//                dp[i] = dp[i/2] + 1;
//            } else {
//                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
//            }
//        }
//        return n % 2 == 0 ? dp[n / 2] : Math.min(dp[(n - 1) / 2] + 2, dp[(n + 1) / 2] + 2);
    }
}
