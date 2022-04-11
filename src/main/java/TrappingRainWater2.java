
/**
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
 *
 */

/*
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small pounds 1 and 3 units trapped.
The total volume of water trapped is 4.

Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 */

public class TrappingRainWater2 {

    public static void main(String[] args) {
        int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4},{2,3,3,2,3,1}};
        TrappingRainWater2 water2 = new TrappingRainWater2();
        System.out.println("Output : " + water2.trapRainWater(heightMap));
    }
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        int m = heightMap.length, n = heightMap[0].length;
        for (int i = 0; i < m; ++i) {

        }

        return res;
    }
}
