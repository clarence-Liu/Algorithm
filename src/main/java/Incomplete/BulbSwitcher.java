package Incomplete;

/**
 * 319. Bulb Switcher
 * <p>There are <tt>n</tt> bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 *
 * <p>On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the <tt>ith</tt> round, you toggle every <tt>i</tt> bulb. For the <tt>nth</tt> round, you only toggle the last bulb.
 *
 * <p><i>Return the number of bulbs that are on after <tt>n</tt> rounds.</i>
 *
 * <p>Constraints:
 * <li>0 <= n <= 10^9</li>
 */

/*
Example 1:
Input: n = 3
Output: 1
Explanation: At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off].
So you should return 1 because there is only one bulb is on.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 1
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n <= 1) {
            return n;
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count = count<<1 ^ 1;
        }
        for (int i = 2; i <= n; ++i) {

//            int temp = 0, k = i - 1;
//            while(k < n) {
//                temp = temp << i ^ 1;
//                k += i;
//            }
//            temp <<= (n- k + i - 1);
//            temp ^= 1 << (n-1);
//            dec(temp, n);
//            count = count ^ temp;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += count & 1;
            count >>= 1;
        }
        return res;
    }

    private static void dec (int num, int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append(num & 1);
            num >>= 1;
        }
        System.out.println("二进制： " + buffer.reverse().toString());
    }
}
