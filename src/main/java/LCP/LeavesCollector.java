package LCP;

/**
 * LCP 19. 秋叶收藏集
 * <p>小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。
 * <p>每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * <p>提示：
 *      <p>3 <= leaves.length <= 10^5
 *      <p>leaves 中只包含字符 'r' 和字符 'y'
 */

/*
示例 1：
输入：leaves = "rrryyyrryyyrr"
输出：2
解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"

示例 2：
输入：leaves = "ryr"
输出：0
解释：已符合要求，不需要额外操作
 */
public class LeavesCollector {

    public int minimumOperations(String leaves) {
        int r = (leaves.charAt(0) == 'r'? 0 : 1) + (leaves.charAt(1) == 'r'? 0 : 1);
        int ry = (leaves.charAt(0) == 'r'? 0 : 1) + (leaves.charAt(1) == 'y'? 0 : 1);
        int ryr = ry;
        for (int i = 2; i < leaves.length(); i++) {
            ryr = Math.min(ryr, ry) + (leaves.charAt(i) == 'r'? 0 : 1);
            ry =  Math.min(r, ry) + (leaves.charAt(i) == 'y'? 0 : 1);
            r += (leaves.charAt(i) == 'r'? 0 : 1);
        }
        return ryr;
    }
}
