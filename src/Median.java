import java.util.Scanner;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */

public class Median {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Given the array num1:");
        String[] numString1 = in.nextLine().split(",");
        int[] nums1 = new int[numString1.length];
        for (int i = 0; i < numString1.length; ++i) {
            nums1[i] = Integer.parseInt(numString1[i]);
        }
        System.out.println("Given the array num2:");
        String[] numString2 = in.nextLine().split(",");
        int[] nums2 = new int[numString2.length];
        for (int i = 0; i < numString2.length; ++i) {
            nums2[i] = Integer.parseInt(numString2[i]);
        }
        Median median = new Median();
        System.out.println("Output : " + median.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0) {
            return  (nums2[n / 2 - 1] + nums2[n / 2]) * 1.0 / 2;
        } else if (n == 0){
            return  (nums1[m / 2 - 1] + nums1[m / 2]) * 1.0 / 2;
        }
        int mid = (m + n + 1) / 2 - 1;
        int l1 = 0, l2 = 0, r1 = m - 1, r2 = n - 1;


        return 0;
    }
}
