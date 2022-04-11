package PrefixSum;

/**
 * 304. Range Sum Query 2D - Immutable
 * <p>Given a 2D matrix <tt>matrix</tt>, handle multiple queries of the following type:
 * <ul>
 *     <li>Calculate the <strong>sum</strong> of the elements of <tt>matrix</tt> inside the rectangle defined
 *     by its <strong>upper left corner</strong> <tt>(row1, col1)</tt> and <strong>lower right corner</strong> <tt>(row2, col2)</tt>.</li>
 * </ul>
 *
 * Implement the NumMatrix class:
 * <ul>
 *     <li><tt>NumMatrix(int[][] matrix)</tt> Initializes the object with the integer matrix <tt>matrix</tt>.</li>
 *     <li><tt>int sumRegion(int row1, int col1, int row2, int col2)</tt> Returns the sum of the elements of <tt>matrix</tt> inside the rectangle defined
 *     by its <strong>upper left corner</strong> <tt>(row1, col1)</tt> and <strong>lower right corner</strong> <tt>(row2, col2)</tt>.</li>
 * </ul>
 * Constraints:
 * <ul>
 *     <li>m == matrix.length</li>
 *     <li>n == matrix[i].length</li>
 *     <li>1 <= m, n <= 200</li>
 *     <li>-10^5 <= matrix[i][j] <= 10^5</li>
 *     <li>0 <= row1 <= row2 < m</li>
 *     <li>0 <= col1 <= col2 < n</li>
 *     <li>At most 104 calls will be made to sumRegion.</li>
 * </ul>
 */
/*
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */
public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }

}
