package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1711. Count Good Meals
 */
/*
Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.

Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 */
public class GoodMeals {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String deliciousnessString = scanner.nextLine();
        deliciousnessString = deliciousnessString.substring(1, deliciousnessString.length() - 1);
        String[] foodsArray = deliciousnessString.split(",");
        int[] deliciousness = new int[foodsArray.length];
        for (int i = 0; i < foodsArray.length; ++i) {
            deliciousness[i] = Integer.parseInt(foodsArray[i]);
        }
        GoodMeals meals = new GoodMeals();
        System.out.println("Output : " + meals.countPairs(deliciousness));
    }
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : deliciousness) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        return 0;
    }
}
