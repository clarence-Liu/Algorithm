package Z_Entry;

import Other.TransposeMatrix;

/**
 * 851-900
 */
public class CallFunction18 {
    public static void main(String[] args) {

        // 867. Transpose Matrix
        System.out.println("867. Transpose Matrix");
        TransposeMatrix matrix = new TransposeMatrix();
        System.out.println(Print.print(matrix.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println();
    }
}
