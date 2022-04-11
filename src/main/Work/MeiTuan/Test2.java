package MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
第一行一个正整数n，表示小美手中的序列长度。
第二行n个空格隔开的数字，每个数字只能是1和-1中的一种。
对于80%的数据保证1 <= n <= 500
对于剩余20%的数据保证1 <= n <= 5000
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            numbs.add(in.nextInt());
        }
        System.out.println(getResult(n, numbs));
    }

    private static int getResult(int length, List<Integer> numbs){
        int[] positive = new int[length];
        int[] negative = new int[length];
        if (numbs.get(0) == 1) {
            positive[0] = 1;
        } else {
            negative[0] = 1;
        }
        for (int i = 1; i < length; ++i) {
            if (numbs.get(i) == 1) {
                positive[i] = positive[i-1]+1;
                if (negative[i-1] > 0)
                    negative[i] = negative[i - 1];
            } else {
                if (negative[i-1] > 0)
                    positive[i] = negative[i - 1];
                negative[i] = positive[i - 1] + 1;
            }
        }
        int max = 0;
        for (int num : positive) {
            max += num;
        }
        return max;
    }
}
