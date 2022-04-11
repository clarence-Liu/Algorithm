package Other;

/**
 * 867. Transpose Matrix
 * Given a 2D integer array matrix, return the <strong>transpose</strong> of matrix.
 *
 * <p>The <strong>transpose</strong> of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 *
 * <p>Constraints:
 *      <br>m == matrix.length
 *      <br>n == matrix[i].length
 *      <br>1 <= m, n <= 1000
 *      <br>1 <= m * n <= 10^5
 *      <br>-10^9 <= matrix[i][j] <= 10^9
 */

/*
Example 1:
Input: matrix = {{1,2,3},{4,5,6},{7,8,9}}
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:
Input: matrix = {{1,2,3},{4,5,6}}
Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
