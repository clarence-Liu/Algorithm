package Z_Entry;

import LCP.CalculationRobot;
import LCP.Checkerboard;
import LCP.LeavesCollector;
import LCP.MagicSort;

public class CallFunctionLCP {
    public static void main(String[] args) {
        // LCP 17. 速算机器人
        System.out.println("LCP 17. 速算机器人");
        CalculationRobot robot = new CalculationRobot();
        System.out.println("Output : " + robot.calculate("AB"));
        System.out.println();

        // LCP 19. 秋叶收藏集
        System.out.println("LCP 19. 秋叶收藏集");
        LeavesCollector collector = new LeavesCollector();
        System.out.println("Output : " + collector.minimumOperations("rrryyyrryyyrr"));
        System.out.println();

        // LCP 22. 黑白方格画
        System.out.println("LCP 22. 黑白方格画");
        Checkerboard checkerboard = new Checkerboard();
        System.out.println("Output : " + checkerboard.paintingPlan(3, 8));
        System.out.println();

        // LCP 23. 魔术排列
        System.out.println("LCP 23. 魔术排列");
        MagicSort sort = new MagicSort();
        System.out.println("Output : " + sort.isMagic(new int[]{2,4,3,1,5}));
        System.out.println();
    }
}
