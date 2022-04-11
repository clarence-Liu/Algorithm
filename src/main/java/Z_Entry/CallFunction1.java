package Z_Entry;

import HashTable.TwoSum;

/**
 * 1-50
 */
public class CallFunction1 {
    public static void main(String[] args) {
        // 1. Two Sum
        System.out.println("1. Two Sum");
        TwoSum twoSum = new TwoSum();
        int[] ans = twoSum.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("Output : " + "[" + ans[0] + "," + ans[1] + "]");
        System.out.println();
    }
}
