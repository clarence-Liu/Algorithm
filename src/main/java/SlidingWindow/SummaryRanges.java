package SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 228. Summary Ranges
 * <p>You are given a <strong>sorted unique</strong> integer array nums.
 *
 * <p>Return the <strong>smallest sorted</strong> list of ranges that <strong>cover all the numbers in the array exactly</strong>.
 * That is, each element of {@code nums} is covered by exactly one of the ranges, and there is no integer {@code x} such that {@code x} is in one of the ranges but not in {@code nums}.
 *
 * <p>Each range {@code [a,b]} in the list should be output as:
 *      <p>"a->b" if a != b
 *      <p>"a" if a == b
 *
 * <p>Constraints:
 *
 *      <p>0 <= nums.length <= 20
 *      <p>-2^31 <= nums[i] <= 2^31 - 1
 *      <p>All the values of nums are unique.
 *      <p>nums is sorted in ascending order.
 */
/*
Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

Example 3:
Input: nums = []
Output: []

Example 4:
Input: nums = [-1]
Output: ["-1"]

Example 5:
Input: nums = [0]
Output: ["0"]
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> res = new ArrayList<>();
        if (length <= 0) {
            return res;
        } else if (length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int l = 0;
        for (int i = 1; i <= length; i++) {
            if (i == length || nums[i] != nums[i - 1] + 1) {
                if (l == i - 1) {
                    res.add(Integer.toString(nums[l]));
                } else {
                    res.add(nums[l] + "->" + nums[i - 1]);
                }
                l = i;
            }
        }
        return res;
    }
}
