package Recursion;

import java.util.Scanner;

/**
 * 50. Pow(x,n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
public class MyPow {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the number x:");
        double x = scanner.nextDouble();
        System.out.println("Given the pow n");
        int n = scanner.nextInt();
        MyPow pow = new MyPow();
        System.out.printf("%.5f",pow.myPow(x, n));
    }

    public double myPow(double x, int n) {
        return (long) n >= 0? quickMul(x, n) : 1.0 / quickMul(x, n);
    }

    public double quickMul(double x, long pow) {
        if (pow == 0) {
            return 1.0;
        }
        double y = quickMul(x, pow / 2);
        return pow % 2 == 0 ? y * y : y * y * x;
    }

//    public double quickMul2(double x, long pow) {
//        double ans = 1.0;
//        double x_contribute = x;
//        //对 pow 进行二进制拆分
//        while (pow > 0) {
//            if (pow % 2 == 1) {
//                //If the lowest bit of pow binary representation is 1, then the contribution is counted
//                ans *= x_contribute;
//            }
//            x_contribute *= x_contribute;
//            //Discard the lowest bit of pow binary representation
//            pow /= 2;
//        }
//        return ans;
//    }

}
