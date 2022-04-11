package LCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCP 23. 魔术排列
 * <p>秋日市集上，魔术师邀请小扣与他互动。魔术师的道具为分别写有数字 1~N 的 N 张卡牌，然后请小扣思考一个 N 张卡牌的排列 target。
 *
 * <p>魔术师的目标是找到一个数字 k（k >= 1），使得初始排列顺序为 1~N 的卡牌经过特殊的洗牌方式最终变成小扣所想的排列 target，特殊的洗牌方式为：
 *
 * <p>第一步，魔术师将当前位于 偶数位置的卡牌（下标自 1 开始），保持当前排列顺序放在位于奇数位置的卡牌之前。例如：将当前排列[1,2,3,4,5]位于偶数位置的[2,4]置于奇数位置的[1,3,5]前，排列变为[2,4,1,3,5]；
 * <p>第二步，若当前卡牌数量小于等于 k，则魔术师按排列顺序取走全部卡牌；若当前卡牌数量大于 k，则取走前 k 张卡牌，剩余卡牌继续重复这两个步骤，直至所有卡牌全部被取走；
 * <p>卡牌按照魔术师取走顺序构成的新排列为「魔术取数排列」，请返回是否存在这个数字 k 使得「魔术取数排列」恰好就是 target，从而让小扣感到大吃一惊。
 *
 * <p>提示：
 *      <p>1 <= target.length = N <= 5000
 *      <p>题目保证 target 是 1~N 的一个排列。
 */

/*
示例 1：
输入：target = [2,4,3,1,5]
输出：true
解释：排列 target 长度为 5，初始排列为：1,2,3,4,5。我们选择 k = 2：
第一次：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]。取走前 2 张卡牌 2,4，剩余 [1,3,5]；
第二次：将当前排列 [1,3,5] 位于偶数位置的 [3] 置于奇数位置的 [1,5] 前，排列变为 [3,1,5]。取走前 2 张 3,1，剩余 [5]；
第三次：当前排列为 [5]，全部取出。
最后，数字按照取出顺序构成的「魔术取数排列」2,4,3,1,5 恰好为 target。

示例 2：
输入：target = [5,4,3,2,1]
输出：false
解释：无法找到一个数字 k 可以使「魔术取数排列」恰好为 target。

 */
public class MagicSort {
    public boolean isMagic(int[] target) {
        int length = target.length;
        List<Integer> reference = new ArrayList<Integer>();
        for (int i = 2; i <= length; i += 2) {
            reference.add(i);
        }
        for (int i = 1; i <= length; i += 2) {
            reference.add(i);
        }
        int k = 0;
        for (k = 0; k < length; k++) {
            if(reference.get(k) != target[k]){
                break;
            }
        }
        if (k == 0) {
            return false;
        }
        List<Integer> result = new ArrayList<Integer>();
        while (reference.size() > 0) {
            if (reference.size() > k) {
                result.addAll(reference.subList(0, k));
                reference.removeAll(reference.subList(0, k));
            } else {
                result.addAll(reference);
                reference.clear();
            }
            if (reference.size() > 0) {
                List<Integer> jishu = new ArrayList<>();
                List<Integer> oushu = new ArrayList<>();
                for (int i = 1; i < reference.size(); i += 2) {
                    oushu.add(reference.get(i));
                }
                for (int i = 0; i < reference.size(); i += 2) {
                    jishu.add(reference.get(i));
                }
                reference.clear();
                reference.addAll(oushu);
                reference.addAll(jishu);
            }
        }
        for (int i = 0; i < length; i++) {
            if (result.get(i) != target[i])
                return false;
        }
        return true;
    }

}
