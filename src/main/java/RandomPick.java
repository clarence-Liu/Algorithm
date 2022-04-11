import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given an array of positive integers w where w[i] describes the weight of i_th index (0-indexed).
 *
 * We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1].
 *      pickIndex() should return the integer proportional to its weight in the w array.
 *      For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while
 *      the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).
 *
 * More formally, the probability of picking index i is w[i] / sum(w).
 */

/*
Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. Since there is only one single element on the array the only option is to return the first element.
Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It's returning the first element (index = 0) that has probability of 1/4.

Since this is a randomization problem, multiple answers are allowed so the following outputs can be considered correct :
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.
 */


public class RandomPick {

    private int[] pre;
    private int sum;

    public RandomPick(int[] w) {
        int length = w.length;
        pre = new int[length];
        pre[0] = w[0];
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        sum = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int random = (int) (Math.random() * sum) + 1;
        return binarySearch(random);
    }

    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operator = in.nextLine();
        String[] operators = operator.substring(1, operator.length() - 1)
                .replace("\"","")
                .split(",");
        String weightString = in.nextLine();
        String[] weights = weightString.substring(3, weightString.indexOf("]"))
                .split(",");
        int length = weights.length;
        int[] weight = new int[length];
        for (int i = 0; i < length; i++) {
            weight[i] = Integer.parseInt(weights[i]);
        }
        RandomPick randomPick = new RandomPick(weight);
        for (String s :
                operators) {
            if (s.equals("pickIndex")) {
                System.out.println(randomPick.pickIndex());
            }
        }
    }
}
