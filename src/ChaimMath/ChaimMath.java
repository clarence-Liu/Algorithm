package ChaimMath;

public class ChaimMath {

    public double quickMul(double x, long pow) {
        double res = 1.0;
        double x_contribute = x;
        //对 pow 进行二进制拆分
        while (pow > 0) {
            if (pow % 2 == 1) {
                //If the lowest bit of pow binary representation is 1, then the contribution is counted
                res *= x_contribute;
            }
            x_contribute *= x_contribute;
            //Discard the lowest bit of pow binary representation
            pow /= 2;
        }
        return res;
    }
}
