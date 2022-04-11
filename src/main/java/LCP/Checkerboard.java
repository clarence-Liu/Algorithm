package LCP;

/**
 * LCP 22. 黑白方格画
 * <p>小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。绘画规则为，
 * <p>小扣可以选择任意多行以及任意多列的格子涂成黑色（选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
 *
 * <p>小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
 *
 * <p>注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 *
 * <p>限制：
 *      <p>1 <= n <= 6
 *      <p>0 <= k <= n * n
 */

/*
示例 1：
输入：n = 2, k = 2
输出：4
解释：一共有四种不同的方案：
第一种方案：涂第一列；
第二种方案：涂第二列；
第三种方案：涂第一行；
第四种方案：涂第二行。

示例 2：
输入：n = 2, k = 1
输出：0
解释：不可行，因为第一次涂色至少会涂两个黑格。

示例 3：
输入：n = 2, k = 4
输出：1
解释：共有 2*2=4 个格子，仅有一种涂色方案。
 */
public class Checkerboard {
    public int paintingPlan(int n, int k) {
        if (k == n * n || k == 0) {
            return 1;
        } else if (k < n) {
            return 0;
        }
        int[] factorial = new int[n + 1];
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        int row = k / n, col = 0;
        int res = 0;
        if (row * n == k) {
            res += 2 * (factorial[n] / (factorial[row] * factorial[n - row]));
            row--;
            col++;
        }
        while (row >= col) {
            if (row * n + col * n - row * col < k) {
                col++;
            } else if (row * n + col * n - row * col > k) {
                row--;
            } else {
                int temp = (factorial[n] / (factorial[row] * factorial[n - row])) * (factorial[n] / (factorial[col] * factorial[n - col]));
                if (row == col) {
                    res += temp;
                } else {
                    res += 2 * temp;
                }
                row--;
                col++;
            }

        }
        return res;
    }
}
