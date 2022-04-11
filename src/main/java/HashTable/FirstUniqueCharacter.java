package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * <p>Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * <p>Constraints:
 *      <p>1 <= s.length <= 105
 *      <p>s consists of only lowercase English letters.
 */

/*
Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                map.put(c, i);
                visited[c - 'a'] = true;
            } else {
                map.remove(c);
            }
        }

        if (!map.isEmpty()) {
            int min = length;
            for (Integer integer : map.values()) {
                min = Math.min(min, integer);
            }
            return min;
        }
        return -1;
    }

}
