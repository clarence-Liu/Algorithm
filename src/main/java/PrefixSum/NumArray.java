package PrefixSum;

/**
 * 303. Range Sum Query - Immutable
 * <p>Given an integer array nums, handle multiple queries of the following type:
 *
 * <p>Calculate the <strong>sum</strong> of the elements of nums between indices {@code left} and {@code right} <strong>inclusive</strong> where {@code left <= right}.
 * <p>Implement the NumArray class:
 *      <br><tt>NumArray(int[] nums)</tt> Initializes the object with the integer array nums.
 *      <br><tt>int sumRange(int left, int right)</tt> Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 * <p>Constraints:
 *      <br>1 <= nums.length <= 10^4
 *      <br>-10^5 <= nums[i] <= 10^5
 *      <br>0 <= left <= right < nums.length
 *      <br>At most 10^4 calls will be made to sumRange.
 */

/*
Example 1:
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */
public class NumArray {

    private int[] sum;
    public NumArray(int[] nums) {
        int length = nums.length;
        sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - (left == 0 ? 0 : sum[left - 1]);
    }
}
