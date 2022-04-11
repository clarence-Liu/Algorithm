package Incomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 391. Perfect Rectangle
 * <p>Given an array <tt>rectangles</tt> where <tt>rectangles[i] = [xi, yi, ai, bi]</tt> represents an axis-aligned rectangle.
 * The bottom-left point of the rectangle is <tt>(xi, yi)</tt> and the top-right point of it is <tt>(ai, bi)</tt>.
 *
 * <p>Return <tt>true</tt> if all the rectangles together form an exact cover of a rectangular region.
 *
 * <p>Constraints:
 * <ul>
 *     <li><tt>1 <= rectangles.length <= 2 * 104</tt></li>
 *     <li><tt>rectangles[i].length == 4</tt></li>
 *     <li><tt>-10^5 <= xi, yi, ai, bi <= 10^5</tt></li>
 * </ul>
 */

/*
Example 1:
Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
Output: true
Explanation: All 5 rectangles together form an exact cover of a rectangular region.

Example 2:
Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
Output: false
Explanation: Because there is a gap between the two rectangular regions.

Example 3:
Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
Output: false
Explanation: Because there is a gap in the top center.

Example 4:
Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
Output: false
Explanation: Because two of the rectangles overlap with each other.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        return true;
    }

//    public boolean isRectangleCover(int[][] rectangles) {
//        int n = rectangles.length;
//        int[][] rs = new int[n * 2][4];
//        for (int i = 0, idx = 0; i < n; i++) {
//            int[] re = rectangles[i];
//            rs[idx++] = new int[]{re[0], re[1], re[3], 1};
//            rs[idx++] = new int[]{re[2], re[1], re[3], -1};
//        }
//        Arrays.sort(rs, (a, b)->{
//            if (a[0] != b[0]) return a[0] - b[0];
//            return a[1] - b[1];
//        });
//        n *= 2;
//        // 分别存储相同的横坐标下「左边的线段」和「右边的线段」 (y1, y2)
//        List<int[]> l1 = new ArrayList<>(), l2 = new ArrayList<>();
//        for (int l = 0; l < n; ) {
//            int r = l;
//            l1.clear(); l2.clear();
//            // 找到横坐标相同部分
//            while (r < n && rs[r][0] == rs[l][0]) r++;
//            for (int i = l; i < r; i++) {
//                int[] cur = new int[]{rs[i][1], rs[i][2]};
//                List<int[]> list = rs[i][3] == 1 ? l1 : l2;
//                if (list.isEmpty()) {
//                    list.add(cur);
//                } else {
//                    int[] prev = list.get(list.size() - 1);
//                    if (cur[0] < prev[1]) return false; // 存在重叠
//                    else if (cur[0] == prev[1]) prev[1] = cur[1]; // 首尾相连
//                    else list.add(cur);
//                }
//            }
//            if (l > 0 && r < n) {
//                // 若不是完美矩形的边缘竖边，检查是否成对出现
//                if (l1.size() != l2.size()) return false;
//                for (int i = 0; i < l1.size(); i++) {
//                    if (l1.get(i)[0] == l2.get(i)[0] && l1.get(i)[1] == l2.get(i)[1]) continue;
//                    return false;
//                }
//            } else {
//                // 若是完美矩形的边缘竖边，检查是否形成完整一段
//                if (l1.size() + l2.size() != 1) return false;
//            }
//            l = r;
//        }
//        return true;
//    }
}
