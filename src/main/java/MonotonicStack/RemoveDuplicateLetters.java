package MonotonicStack;

import java.util.*;

/**
 * 316. Remove Duplicate Letters
 * <p>Given a string s, remove duplicate letters so that every letter appears once and only once.
 * <p>You must make sure your result is the smallest in lexicographical order among all possible results.
 */

/*
Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Example 3:
Input: s = "cdadabcc"
Output: "adbc"

Example 4:
Input: s = "bbcaac"
Output: "bac"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int length = s.length();
        boolean[] visited = new boolean[26];
        int[] nums = new int[26];
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length; i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                while (res.length() > 0 && res.charAt(res.length() - 1) > c && nums[res.charAt(res.length() - 1) - 'a'] > 0) {
                    visited[res.charAt(res.length() - 1) - 'a'] = false;
                    res.deleteCharAt(res.length() - 1);
                }
                res.append(c);
                visited[ c - 'a'] = true;
            }
            nums[c - 'a']--;
        }
        return res.toString();
    }
}
