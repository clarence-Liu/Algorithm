package TwoPointers;

/**
 * 189. Rotate Array
 * <p>Given an array, rotate the array to the right by {@code k} steps, where {@code k} is non-negative.
 *
 * <p>Constraints:
 *      <p>1 <= nums.length <= 10^5
 *      <p>-2^31 <= nums[i] <= 2^31 - 1
 *      <p>0 <= k <= 10^5
 */
/*
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int mid = length - k;
        for (int i = 0, j = mid - 1; i < j; i++, --j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
        for (int i = mid, j = length - 1; i < j; i++, --j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
        for (int i = 0, j = length - 1; i < j; i++, --j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
//        StringBuilder builder = new StringBuilder();
//        builder.append("Output : [");
//        for (int num : nums) {
//            builder.append(num).append(",");
//        }
//        builder.replace(builder.length() - 1, builder.length(), "]");
//        System.out.println(builder.toString());
    }

}
