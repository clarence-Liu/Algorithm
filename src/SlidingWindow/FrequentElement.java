package SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1838. Frequency of the Most Frequent Element
 *
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation,
 * you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 */
/*
Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

Example 2:
Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

Example 3:
Input: nums = [3,9,6], k = 2
Output: 1
 */
public class FrequentElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Given the numb array :");
        String[] numString = in.nextLine().split(",");
        int[] nums = new int[numString.length];
        for (int i = 0; i < numString.length; ++i) {
            nums[i] = Integer.parseInt(numString[i]);
        }
        System.out.println("Given the k:");
        int k = in.nextInt();
        FrequentElement element = new FrequentElement();
        System.out.println("Output : " + element.maxFrequency(nums, k));
        System.out.println("Output : " + element.maxFrequency2(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int maxFrequency2(int[] nums, int k) {
        int maxLength = 1;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            int numb = nums[i];
            int start = i, end = i;
            while (end < length - 1 && nums[end + 1] == numb) {
                ++end;
            }
            int step = k;
            while (start > 0 && step > 0 && numb - nums[start - 1] <= step) {
                step -= numb - nums[start - 1];
                start--;
            }
            maxLength = Math.max(maxLength , end - start + 1);
            i = end;
        }
        return maxLength;
    }
}
