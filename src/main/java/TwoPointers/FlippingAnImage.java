package TwoPointers;

/**
 * 832. Flipping an Image
 * <p>Given an {@code n x n} binary matrix {@code image}, flip the image <strong>horizontally</strong>, then invert it, and return the resulting image.
 *
 * <p>To flip an image horizontally means that each row of the image is reversed.
 * <p>For example, flipping {@code [1,1,0]} horizontally results in {@code [0,1,1]}.
 * <p>
 * <p>To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * <p>For example, inverting [0,1,1] results in [1,0,0].
 * <p>
 * <p>Constraints:
 *      <p>n == image.length
 *      <p>n == image.lengthn == image[i].length
 *      <p>n == image.length1 <= n <= 20
 *      <p>images[i][j] is either 0 or 1.
 */

/*
Example 1:
Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = n - 1; l <= r; l++, r--) {
                image[i][l] = (image[i][l] + 1) % 2;
                if (l != r) {
                    image[i][r] = (image[i][r] + 1) % 2;
                    image[i][l] += image[i][r];
                    image[i][r] = image[i][l] - image[i][r];
                    image[i][l] -= image[i][r];
                }
            }
        }
        return image;
    }
}
