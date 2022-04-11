package Other;

/**
 * 495. Teemo Attacking
 * <p>Our hero Teemo is attacking an enemy Ashe with poison attacks!
 * When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds.
 * More formally, an attack at second <tt>t</tt> will mean Ashe is poisoned during the <strong>inclusive</strong> time interval <tt>[t, t + duration - 1]</tt>.
 * If Teemo attacks again <strong>before</strong> the poison effect ends, the timer for it is <strong>reset</strong>, and the poison effect will end <tt>duration</tt> seconds after the new attack.
 *
 * <p>You are given a <strong>non-decreasing</strong> integer array <tt>timeSeries</tt>, where <tt>timeSeries[i]</tt> denotes that Teemo attacks Ashe at second <tt>timeSeries[i]</tt>, and an integer <tt>duration</tt>.
 *
 * <p>Return the <strong>total</strong> number of seconds that Ashe is poisoned.
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= timeSeries.length <= 10^4</tt></li>
 *     <li><tt>0 <= timeSeries[i], duration <= 10^7</tt></li>
 *     <li>timeSeries is sorted in non-decreasing order.</li>
 * </ul>
 */

/*
Example 1:
Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

Example 2:
Input: timeSeries = [1,2], duration = 2
Output: 3
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        res += duration;
        return res;
    }
}
