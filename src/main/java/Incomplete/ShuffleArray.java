package Incomplete;

import java.util.Random;

/**
 * 384. Shuffle an Array
 * <p>Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be <strong>equally likely</strong> as a result of the shuffling.
 *
 * <p>Implement the Solution class:
 * <ul>
 *     <li><tt>Solution(int[] nums)</tt> Initializes the object with the integer array nums.</li>
 *     <li><tt>int[] reset()</tt> Resets the array to its original configuration and returns it.</li>
 *     <li><tt>int[] shuffle()</tt> Returns a random shuffling of the array.</li>
 * </ul>
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= nums.length <= 200</tt></li>
 *     <li><tt>-10^6 <= nums[i] <= 10^6</tt></li>
 *     <li>All the elements of nums are unique.</li>
 *     <li>At most 5 * 10^4 calls in total will be made to reset and shuffle.</li>
 * </ul>
 */
/*
Example 1:
Input
["Solution", "shuffle", "reset", "shuffle"]
 [[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
// Any permutation of [1,2,3] must be equally likely to be returned.
// Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */
public class ShuffleArray {
    private final int[] nums;
    private final int[] original;
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0,original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
