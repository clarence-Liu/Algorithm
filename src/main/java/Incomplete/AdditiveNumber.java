package Incomplete;

/**
 * 306. Additive Number
 * <p>An <strong>additive number</strong> is a string whose digits can form an <strong>additive sequence</strong>.
 *
 * <p>A valid <strong>additive sequence</strong> should contain <strong>at least</strong> three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * <p>Given a string containing only digits,
 * return true if it is an <strong>additive number</strong> or false otherwise.
 *
 * <p><strong>Note</strong>: Numbers in the additive sequence <strong>cannot</strong> have leading zeros,
 * so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>Constraints:
 *     <ul>
 *         <li><tt>1 <= num.length <= 35</tt></li>
 *         <li><tt>num consists only of digits.</tt></li>
 *     </ul>
 */
/*
Example 1:
Input: "112358"
Output: true
Explanation:
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

Example 2:
Input: "199100199"
Output: true
Explanation:
The additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
 */
public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int i = 1; i < length - 1; ++i) {
            if (num.charAt(0) == '0' && i != 1) {
                break;
            }
            for (int j = i; j < length - 1; ++j) {
                if (num.charAt(i) == 0 && j != i) {
                    break;
                }
                if (valid(i, j ,num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean valid(int start, int end, String num) {
        int firstStart = 0, firstEnd = start - 1;
        int secondStart = start, secondEnd = end;
        while (secondEnd <= num.length() - 1) {
            int cur = 0, pre = 0;
            StringBuffer buffer = new StringBuffer();
            while (firstEnd >= firstStart || secondEnd >= secondStart) {
                cur = pre;
                if (firstEnd >= firstStart) {
                    cur += num.charAt(firstEnd) - '0';
                    firstEnd--;
                }
                if (secondEnd >= secondStart) {
                    cur += num.charAt(secondEnd);
                    secondEnd--;
                }
                pre = cur / 10;
                cur = cur % 10;
                buffer.append(cur);
            }
        }
        return false;
    }


}
