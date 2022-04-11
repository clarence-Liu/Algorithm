package DynamicProgramming;

/**
 * 746. Min Cost Climbing Stairs
 * <p>You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * <p>Once you pay the cost, you can either climb one or two steps.
 *
 * <p>You can either start from the step with index 0, or the step with index 1.
 *
 * <p>Return the minimum cost to reach the top of the floor.
 *
 * <p>Constraints:
 *
 *      <p>2 <= cost.length <= 1000
 *      <p>0 <= cost[i] <= 999
 */
/*
Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 */

public class ClimbStairs {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] costs = new int[length + 1];
        costs[0] = cost[0];
        costs[1] = cost[1];
        for (int i = 2; i <= length; ++i) {
            costs[i] = Math.min(costs[i - 1],costs[i - 2]) + (i == length ? 0 : cost[i]) ;
        }
        return costs[length];
    }
}
