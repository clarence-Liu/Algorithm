package BinarySearch;

import java.util.Scanner;

/**
 * 483. Smallest Good Base
 * Given an integer n represented as a string, return the smallest good base of n.
 * We call k >= 2 a good base of n, if all digits of n base k are 1's.
 */

/*
Input: n = "13"
Output: "3"
Explanation: 13 base 3 is 111.
Example 2:

Input: n = "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.
Example 3:

Input: n = "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.
 */
public class SmallestGoodBase {
    public static void main(String[] args){
        System.out.println("Give the string of the number:");
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String base = smallestGoodBase(n);
        System.out.println(base);
    }

    public static String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int)Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; --m) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; ++i) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }
}
