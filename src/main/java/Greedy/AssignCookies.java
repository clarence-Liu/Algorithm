package Greedy;

import java.util.Arrays;

/**
 * <p>455. Assign Cookies
 * <p>Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * <p>Each child {@code i} has a greed factor {@code g[i]}, which is the minimum size of a cookie that the child will be content with;
 * and each cookie {@code j} has a size {@code s[j]}. If {@code s[j] >= g[i]}, we can assign the cookie {@code j} to the child {@code i}, and the child {@code i} will be content.
 * <p>Your goal is to maximize the number of your content children and output the maximum number.
 *
 * <p>Constraints:
 *      <p>1 <= g.length <= 3 * 10^4
 *      <p>0 <= s.length <= 3 * 10^4
 *      <p>1 <= g[i], s[j] <= 2^31 - 1
 */

/*
Example 1:
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

Example 2:
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all the children,
You need to output 2.
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greedLength = g.length, cookieLength = s.length;
        int res = 0;
        for (int i = 0, j = 0; i < greedLength && j < cookieLength; ++i, ++j) {
            while (j < cookieLength && g[i] > s[j]) {
                ++j;
            }
            if (j < cookieLength) {
                ++res;
            }
        }
        return res;
    }
}
