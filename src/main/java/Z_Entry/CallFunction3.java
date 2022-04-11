package Z_Entry;

import BackTracking.PalindromePartitioning;

/**
 * 101-150
 */
public class CallFunction3 {
    public static void main(String[] args) {
        // 131. Palindrome Partitioning
        System.out.println("131. Palindrome Partitioning");
        PalindromePartitioning partitioning = new PalindromePartitioning();
        System.out.println(Print.print(partitioning.partition("aab")));
        System.out.println();
    }
}
