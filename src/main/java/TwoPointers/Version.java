package TwoPointers;

import java.util.Scanner;

/**
 * 165. Compare TwoPointers.Version Numbers
 * Given two version numbers, version1 and version2, compare them.
 *
 * TwoPointers.Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros.
 * Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *      If version1 < version2, return -1.
 *      If version1 > version2, return 1.
 *      Otherwise, return 0.
 */
/*
Example 1:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 2:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".

Example 3:
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.

Example 4:
Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 5:
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
 */
public class Version {

    public int compareVersion(String version1, String version2) {
        int length1 = version1.length(), length2 = version2.length();
        int start1 = 0, start2 = 0;
        while (start1 < length1 || start2 < length2) {
            int v1 = 0, v2 = 0;
            for (; start1 < length1 && version1.charAt(start1) != '.'; ++start1) {
                v1 = v1 * 10 + version1.charAt(start1) - '0';
            }
            ++start1;
            for (; start2 < length2 && version2.charAt(start2) != '.'; ++start2) {
                v2 = v2 * 10 + version2.charAt(start2) - '0';
            }
            ++start2;
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String version1 = in.nextLine();
        String version2 = in.nextLine();
        Version version = new Version();
        System.out.println("Output : " + version.compareVersion(version1, version2));
    }

}
