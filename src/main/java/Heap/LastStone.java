package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * <p>You are given an array of integers stones where <code>stones[i]</code> is the weight of the <code>i^th</code> stone.
 *
 * <p>We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * <p>Suppose the heaviest two stones have weights x and y with <code>x <= y</code>. The result of this smash is:
 *
 *      <p>If <code>x == y</code>, both stones are destroyed, and
 *      <p>If <code>x != y</code>, the stone of weight {@code x} is destroyed, and the stone of weight {@code y} has new weight {@code y-x}.
 *      <p>At the end of the game, there is at most one stone left.
 *
 * <p>Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 * <p>Constraints:
 *      <p>1 <= stones.length <= 30
 *      <p>1 <= stones[i] <= 1000
 */

/*
Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
Input: stones = [1]
Output: 1
 */
public class LastStone {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x > y) {
                queue.offer(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
