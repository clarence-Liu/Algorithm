package Greedy;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * <p>Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * <p>Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * <p>Constraints:
 *      <p>1 <= prices.length <= 5 * 10^4
 *      <p>1 <= prices[i] < 5 * 10^4
 *      <p>0 <= fee < 5 * 10^4
 */

/*
Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Example 2:
Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 */
public class StockWithFee {

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int [][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][0];
    }
}
