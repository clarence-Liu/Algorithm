package Incomplete;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. Hand of Straights
 * <p>Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size {@code groupSize}, and consists of {@code groupSize} consecutive cards.
 * <p>Given an integer array {@code hand} where {@code hand[i]} is the value written on the {@code ith} card and an integer {@code groupSize}, return {@code true} if she can rearrange the cards, or {@code false} otherwise.
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= hand.length <= 10^4</tt></li>
 *     <li><tt>0 <= hand[i] <= 10^9</tt></li>
 *     <li><tt>1 <= groupSize <= hand.length</tt></li>
 * </ul>
 */
/*
Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:
Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.
 */
public class Straight {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> record = new HashMap<>();
        for (int x : hand) {
            record.put(x, record.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!record.containsKey(x)) {
                continue;
            }
            for (int i = 0; i < groupSize; ++i) {
                if (!record.containsKey(x + i)) {
                    return false;
                }
                record.put(x + i, record.get(x + i) - 1);
                if (record.get(x + i) == 0) {
                    record.remove(x + i);
                }
            }
        }
        return true;
    }
}
