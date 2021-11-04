import java.util.Scanner;
import java.util.Stack;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * Given an integer array nums, you need to find one continuous subarray that if you only
 * sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 */

/*
Example 1:
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:
Input: nums = [1,2,3,4]
Output: 0

Example 3:
Input: nums = [1]
Output: 0
[2,6,4,8,10,3,9,15]
 */

public class ShortestUnsortedSubarray {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the array:");
        String numsString = scanner.nextLine();
        numsString = numsString.substring(1,numsString.length() - 1);
        String[] numsArray = numsString.split(",");
        int length = numsArray.length;
        int[] nums = new int[length];
        for(int i = 0; i < length; ++i) {
            nums[i] = Integer.parseInt(numsArray[i]);
        }
        ShortestUnsortedSubarray shortestUnsortedSubarray = new ShortestUnsortedSubarray();
        System.out.println("Output : " + shortestUnsortedSubarray.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int start = 0, end = length - 1;
        while (start < length - 1 && nums[start] <= nums[start + 1]) {
            start++;
        }
        while (end > start && nums[end - 1] <= nums[end]) {
            end--;
        }
        int max = nums[start], min = nums[start];
        for (int i = start; i < end; ++i) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        while (end < length && nums[end] < max) {
            min = Math.min(nums[end], min);
            end++;
        }
        while (start > 0 && nums[start - 1] > min) {
            start--;
        }
        System.out.println("Start : " + start);
        System.out.println("End : " + end);
        return start == end ? 0 : end - start;
    }
}
