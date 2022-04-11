import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * The geometric information of each building is given in the array buildings where buildings[i] = [left_i, right_i, height_i]:
 *      left_i is the x coordinate of the left edge of the ith building.
 *      right_i is the x coordinate of the right edge of the ith building.
 *      height_i is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form
 * [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline
 * except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's
 * termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings
 * should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline.
 * For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable;
 * the three lines of height 5 should be merged into one in the final output as such:
 * [...,[2 3],[4 5],[12 7],...]
 */

public class Skyline {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String buildingString = in.nextLine();
        buildingString = buildingString.substring(2, buildingString.length() - 2);
        String[] buildingsArray = buildingString.split("],\\[");
        int[][] buildings = new int[buildingsArray.length][3];
        int i = 0;
        for (String s : buildingsArray) {
            String[] buildingInfo = s.split(",");
            buildings[i][0] = Integer.parseInt(buildingInfo[0]);
            buildings[i][1] = Integer.parseInt(buildingInfo[1]);
            buildings[i][2] = Integer.parseInt(buildingInfo[2]);
        }
        Skyline skyline = new Skyline();
        System.out.println("Output : " + skyline.getSkyline(buildings));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }
}
