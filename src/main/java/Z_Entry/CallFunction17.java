package Z_Entry;


import Incomplete.Straight;
import TwoPointers.FlippingAnImage;

public class CallFunction17 {
    public static void main(String[] args) {
        // 832. Flipping an Image
        System.out.println("832. Flipping an Image");
        FlippingAnImage image = new FlippingAnImage();
//        int[][] res = image.flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}});
        int[][] res = image.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
        System.out.println();

        // 846. Hand of Straights
        System.out.println("846. Hand of Straights");
        Straight straight = new Straight();
        System.out.println("Output: " + straight.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }

}
