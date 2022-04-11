package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. Russian Doll Envelopes
 * <p>You are given a 2D array of integers <tt>envelopes</tt> where <tt>envelopes[i] = [wi, hi]</tt> represents the width and the height of an envelope.
 *
 * <p>One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * <p>Return the <i>maximum number of envelopes you can Russian doll (i.e., put one inside the other)</i>.
 *
 * <p><strong>Note:</strong> You cannot rotate an envelope.
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= envelopes.length <= 5000</tt></li>
 *     <li><tt>envelopes[i].length == 2</tt></li>
 *     <li><tt>1 <= wi, hi <= 10^4</tt></li>
 * </ul>
 */
/*
Example 1:
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:
Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });
        int lenght = envelopes.length;
        int[] dp = new int[lenght];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < lenght; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
