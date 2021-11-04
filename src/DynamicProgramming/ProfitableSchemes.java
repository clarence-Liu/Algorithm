package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 879. 盈利计划
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 */
public class ProfitableSchemes {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n, minProfit;
        System.out.println("Given the number of employees:");
        n = scanner.nextInt();
        System.out.println("Give the minimum profit required:");
        minProfit = scanner.nextInt();
        ArrayList<Integer> group = new ArrayList<>(), profit = new ArrayList<>();
        System.out.println("Give the number of employees required for each job:");
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] str= string.split(" ");
        for (String s : str) {
            group.add(Integer.parseInt(s));
        }
        System.out.println("Give the profit of each job:");
        string = scanner.nextLine();
        System.out.println("out : " + string);
        str= string.split(" ");
        for (String s : str) {
            profit.add(Integer.parseInt(s));
        }

        int total = profitableSchemes(n, minProfit, group.stream().mapToInt(Integer::valueOf).toArray(), profit.stream().mapToInt(Integer::valueOf).toArray());
        System.out.println(total);
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int jobNumber = group.length;
        int MOD = (int)1e9+7;
        int[][][] dpProfits = new int[jobNumber + 1][n + 1][minProfit + 1];
        for (int i = 1; i <= jobNumber; ++i) {
            int engineer = group[i-1], pro = profit[i-1];
            dpProfits[0][0][0] = 1;
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= minProfit; ++k) {
                    if (engineer > j) {
                        dpProfits[i][j][k] = dpProfits[i-1][j][k];
                    } else {
                        dpProfits[i][j][k] = (dpProfits[i - 1][j][k] + dpProfits[i - 1][j - engineer][Math.max(0,k-pro)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; ++i) {
            sum = (sum + dpProfits[jobNumber][i][minProfit]) % MOD;
        }
        return sum;
    }
}
