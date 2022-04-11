package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 299. Bulls and cows
 * <p>You are playing the Bulls and Cows game with your friend.
 *
 * <p>You write down a secret number and ask your friend to guess what the number is.
 * <p>When your friend makes a guess, you provide a hint with the following info:
 *
 *      <p>The number of "bulls", which are digits in the guess that are in the correct position.
 *      <p>The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
 *          Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 *
 * <p>Given the secret number secret and your friend's guess, return the hint for your friend's guess.
 * <p>The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
 * <p>Note that both secret and guess may contain duplicate digits.
 *
 * <p>Constraints:
 *      <p>1 <= secret.length, guess.length <= 1000
 *      <p>secret.length == guess.length
 *      <p>secret and guess consist of digits only.
 */

/*
Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

Example 3:
Input: secret = "1", guess = "0"
Output: "0A0B"

Example 4:
Input: secret = "1", guess = "1"
Output: "1A0B"
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;
        int length = secret.length();
        for (int i = 0; i < length; i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) {
                bulls++;
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s != g && map.containsKey(g) && map.get(g) > 0) {
                map.put(g, map.get(g) - 1);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
