package TwoPointers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 524. Longest Word in Dictionary through Deleting
 * Given a string s and a string array dictionary, return the longest string in the dictionary
 * that can be formed by deleting some of the given string characters.
 * If there is more than one possible result, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 *
 */
/*
Example 1:
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

Example 2:
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 */
public class LongestWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String dictionaryString = in.nextLine();
        String[] dictionaryArray = dictionaryString.substring(1, dictionaryString.length() - 1)
                .replace("\"","")
                .split(",");
        for (String e :
                dictionaryArray) {
            System.out.println(e);
        }
        List<String> dictionary = Arrays.asList(dictionaryArray);
        LongestWord longestWord = new LongestWord();
        System.out.println("Output : " + longestWord.findLongestWord(s, dictionary));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        int length = s.length();
        for (String e : dictionary) {
            int length2 = e.length();
            int i = 0, j = 0;
            while (i < length && j < length2) {
                if (s.charAt(i) == e.charAt(j)) {
                    ++j;
                }
                ++i;
            }
            if (j == length2) {
                if (length2 > res.length() || (length2 == res.length() && e.compareTo(res) < 0)) {
                    res = e;
                }
            }
        }
        return res;
    }
}
