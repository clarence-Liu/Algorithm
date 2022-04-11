package HashTable;

import java.util.*;

/**
 * 187. Repeated DNA Sequences
 * <p>The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *      <p>For example, "ACGAATTCCG" is a DNA sequence.
 * <p>When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * <p>Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 * <p>Constraints:
 * <p>1 <= s.length <= 105
 * <p>s[i] is either 'A', 'C', 'G', or 'T'.
 */
/*
Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        if (length < 10) {
            return new ArrayList<>();
        }
        Map<String, Integer> subSequences = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= length - 10; i++) {
            String sequences = s.substring(i, i + 10);
            subSequences.put(sequences, subSequences.getOrDefault(sequences, 0) + 1);
            if (subSequences.get(sequences) == 2) {
                res.add(sequences);
            }
        }
        return res;
    }
}
