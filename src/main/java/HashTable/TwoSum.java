package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * <p>Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * <p>You can return the answer in any order.
 *
 * <p>Constraints:
 *      <p>2 <= nums.length <= 10^4
 *      <p>-10^9 <= nums[i] <= 10^9
 *      <p>-10^9 <= target <= 10^9
 *      <p>Only one valid answer exists.
 */
/*
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.isEmpty() && map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
