package Z_Entry;

import DynamicProgramming.RussianDollEnvelopes;
import HashTable.FirstUniqueCharacter;
import Incomplete.IntegerReplacement;

public class CallFunction8 {
    public static void main(String[] args) {
        // 354. Russian Doll Envelopes
        System.out.println("354. Russian Doll Envelopes");
        RussianDollEnvelopes envelopes = new RussianDollEnvelopes();
        System.out.println("Output : " + envelopes.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
        System.out.println();

        // 387. First Unique Character in a String
        System.out.println("387. First Unique Character in a String");
        FirstUniqueCharacter character = new FirstUniqueCharacter();
        System.out.println("Output : " + character.firstUniqChar("aadadaad"));
        System.out.println();

        // 397. Integer Replacement
        System.out.println("397. Integer Replacement");
        System.out.println("Output : " + IntegerReplacement.integerReplacement(2147483647));
        System.out.println();
    }
}
