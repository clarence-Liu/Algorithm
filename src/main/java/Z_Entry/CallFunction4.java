package Z_Entry;

import HashTable.RepeatedDNASequences;
import TwoPointers.RotateArray;

/**
 * 151-200
 */

public class CallFunction4 {

    public static void main(String[] args) {
        // 187. Repeated DNA Sequences
        System.out.println("187. Repeated DNA Sequences");
        RepeatedDNASequences dnaSequences = new RepeatedDNASequences();
        System.out.println("Output : " + dnaSequences.findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println();

        // 189. Rotate Array
        System.out.println("189. Rotate Array");
        RotateArray array = new RotateArray();
        array.rotate(new int[]{1,2,3,4,5,6,7}, 3);
        System.out.println();
    }
}
