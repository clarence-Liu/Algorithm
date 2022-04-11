package LCOF;

import java.util.Scanner;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class BinaryOneNumber {

    public static void main(String[] args){
        System.out.println("Give the binary string:");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine(), 2);
        System.out.println(n);
        BinaryOneNumber number = new BinaryOneNumber();
        int result = number.hammingWeight(n);
        System.out.println("result = " + result);
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
