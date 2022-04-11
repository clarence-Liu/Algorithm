package Z_Entry;

import DynamicProgramming.ClimbStairs;
import Greedy.StockWithFee;

public class CallFunction15 {
    public static void main(String[] args) {
        // 714. Best Time to Buy and Sell Stock with Transaction Fee
        System.out.println("714. Best Time to Buy and Sell Stock with Transaction Fee");
        StockWithFee stock = new StockWithFee();
        System.out.println("Output : " + stock.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println();

        // 746. Min Cost Climbing Stairs
        System.out.println("746. Min Cost Climbing Stairs");
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println("Output : " + climbStairs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println();
    }
}
