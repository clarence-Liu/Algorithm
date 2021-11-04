package HashTable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 */
/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Input: s = ""
Output: 0
 */
public class LongestSubstring {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the string :");
        String s = scanner.nextLine();
        int result = lengthOfLongestSubstring(s);
        System.out.println("Output : " + result);
    }

    public  static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        Set<Character> characters = new HashSet<>();
        int index = -1, maxLength = 0;
        String substring = "";
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while(index + 1 < length && !characters.contains(s.charAt(index + 1))) {
                characters.add(s.charAt(++index));
            }
            if (index - i + 1 > maxLength) {
                substring = s.substring(i, index + 1);
            }
            maxLength = Math.max(maxLength, index - i + 1);
        }
        System.out.println("max length : " + maxLength);
        System.out.println("subString : " + substring);
        return maxLength;
    }
}
