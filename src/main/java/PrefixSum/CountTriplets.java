package PrefixSum;

/**
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 * <p>Given an array of integers arr.
 *
 * <p>We want to select three indices <tt>i</tt>, <tt>j</tt> and <tt>k</tt> where <tt>(0 <= i < j <= k < arr.length)</tt>.
 *
 * <p>Let's define <tt>a</tt> and <tt>b</tt> as follows:
 * <ul>
 *     <li><tt>a = arr[i]^arr[i + 1]^...^arr[j - 1]</tt></li>
 *     <li><tt>b = arr[j]^arr[j + 1]^...^arr[k]</tt></li>
 * </ul>
 * <p>Note that ^ denotes the <strong>bitwise-xor</strong> operation.
 *
 * <p>Return the number of triplets <tt>i</tt>, <tt>j</tt> and <tt>k</tt> Where <tt>a == b</tt>.
 *
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= arr.length <= 300</tt></li>
 *     <li><tt>1 <= arr[i] <= 10^8</tt></li>
 * </ul>
 */
/*
Example 1:
Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

Example 2:
Input: arr = [1,1,1,1,1]
Output: 10

Example 3:
Input: arr = [2,3]
Output: 0

Example 4:
Input: arr = [1,3,5,7,9]
Output: 3

Example 5:
Input: arr = [7,11,12,9,5,2,7,17,22]
Output: 8
 */
public class CountTriplets {

    public int countTriplets(int[] arr) {
        int length = arr.length;
        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (((sum[j + 1] ^ sum[i]) == 0)) {
                    res += j - i;
                }
            }
        }
        return res;
    }
}
