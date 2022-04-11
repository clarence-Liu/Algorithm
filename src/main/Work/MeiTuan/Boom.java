package MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boom {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        List<Integer> numbs = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            numbs.add(in.nextInt());
        }
        System.out.println(getResult(n, m, numbs));
    }

    public static int getResult(int n, int m, List<Integer> numbs){
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            count.add(0);
        }
        int xiaohao = 0;
        int bom = 0;
        for (int i = 0; i < m; ++i) {
            int index = numbs.get(i);
            int cishu = count.get(index - 1);
            count.set(index - 1, cishu + 1);
            if (count.get(index - 1) == 1) {
                bom++;
                if (bom == n) {
                    xiaohao++;
                    for (int j = 0; j < n; ++j) {
                        count.set(j, 0);
                    }
                    count.set(index - 1, 1);
                    bom = 1;
                }
            }
        }
        return xiaohao;
    }
}
/*
2 4
2 1 1 2
2
 */
