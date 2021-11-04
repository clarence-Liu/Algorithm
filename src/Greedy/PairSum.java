package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1877. Minimize Maximum Pair Sum in Array
 * he pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
 *
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be
 * max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 *
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 */

public class PairSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Given the num array:");
        String numString = in.nextLine();
        numString = numString.substring(1, numString.length() - 1);
        String[] numsArray = numString.split(",");
        int[] nums = new int[numsArray.length];
        for (int i = 0; i < numsArray.length; ++i) {
            nums[i] = Integer.parseInt(numsArray[i]);
        }
        PairSum sum = new PairSum();
        System.out.println("Output : " + sum.minPairSum(nums));
    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = 0;
        for(int i = 0; i < length / 2; ++i) {
            max = Math.max(max, nums[i] +  nums[length - 1 - i]);
        }
        return max;
    }
}
