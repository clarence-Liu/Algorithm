package Z_Entry;
/**
 * 301-350
 */

import BitOperation.CountingBits;
import Incomplete.AdditiveNumber;
import Incomplete.BulbSwitcher;
import MonotonicStack.RemoveDuplicateLetters;
import PrefixSum.NumArray;
import PrefixSum.NumMatrix;

public class CallFunction7 {
    public static void main(String[] args) {

        // 303. Range Sum Query - Immutable
        System.out.println("303. Range Sum Query - Immutable");
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println("Output : " + numArray.sumRange(0, 2));
        System.out.println("Output : " + numArray.sumRange(2, 5));
        System.out.println("Output : " + numArray.sumRange(0, 5));
        System.out.println();

        // 304. Range Sum Query 2D - Immutable
        System.out.println("304. Range Sum Query 2D - Immutable");
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println("Output : " + numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println("Output : " + numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println("Output : " + numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println();

        // 306. Additive Number
        System.out.println("306. Additive Number");
        System.out.println("Output : " + AdditiveNumber.isAdditiveNumber(""));
        System.out.println();

        // 316. Remove Duplicate Letters
        System.out.println("316. Remove Duplicate Letters");
        RemoveDuplicateLetters letters = new RemoveDuplicateLetters();
        System.out.println("Output : " + letters.removeDuplicateLetters("cdadabcc"));
        System.out.println();

        // 319. Bulb Switcher
        System.out.println("319. Bulb Switcher");
        BulbSwitcher switcher = new BulbSwitcher();
        System.out.println("Output : " + switcher.bulbSwitch(2));
        System.out.println();

        // 338. Counting Bits
        System.out.println("338. Counting Bits");
        CountingBits countingBits = new CountingBits();
        System.out.println("Output : " + Print.print(countingBits.countBits(5)));
        System.out.println();

    }
}
