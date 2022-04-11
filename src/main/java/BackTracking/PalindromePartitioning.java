package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <p>Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * <p>A palindrome string is a string that reads the same backward as forward.
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= s.length <= 16</tt></li>
 *     <li>s contains only lowercase English letters.</li>
 * </ul>
 */
/*
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 */
public class PalindromePartitioning {

    private final List<List<String>> res = new ArrayList<>();
    private final List<String> ans = new ArrayList<>();
    private int length;
    private boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        length = s.length();
        isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int right = 1; right < length ; right++) {
            for (int left = 0; left < right; left++) {
                isPalindrome[left][right] = isPalindrome[left + 1][right - 1] && s.charAt(left) == s.charAt(right);
            }
        }
        dfs(s, 0);
        return res;
    }
    private void dfs(String s, int i){
        if (i == length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < length; j++) {
            if (isPalindrome[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
