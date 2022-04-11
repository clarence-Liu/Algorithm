import java.util.*;

/**
 * 1104. Path In Zigzag Labelled Binary Tree
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 */


public class ZigzagBinaryTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Given the label:");
        int label = in.nextInt();
        ZigzagBinaryTree tree = new ZigzagBinaryTree();
        System.out.println("Output : " + tree.pathInZigZagTree(label).toString());
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int up = 1;
        while (up <= label) {
            up *= 2;
        }
        while (label > 0) {
            res.add(label);
            label = (up - 1 + up / 2 - label) / 2;
            up /= 2;
        }
        Collections.reverse(res);
        return res;
    }
}
