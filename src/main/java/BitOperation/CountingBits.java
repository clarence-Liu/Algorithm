package BitOperation;

/**
 * 338. Counting Bits
 * <p>Given an integer <tt>n</tt>, return an array ans of length <tt>n + 1</tt> such that for each <tt>i (0 <= i <= n)</tt>,
 * <tt>ans[i]</tt> is the number of 1's in the binary representation of <tt>i</tt>.
 * <p>Constraints:
 * <li>0 <= n <= 10^5</li>
 */

/*
Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


 */
public class CountingBits {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i >> 1] + (i % 2 == 0 ? 0 : 1);
        }
        return res;
    }
}
