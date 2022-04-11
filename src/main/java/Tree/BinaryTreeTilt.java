package Tree;

import java.util.ArrayList;

public class BinaryTreeTilt {
    public TreeNode createTree(ArrayList<String> nums) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        nums.forEach(s -> treeNodes.add(s.equals("null")? new TreeNode(0) : new TreeNode(Integer.parseInt(s))));
        int length = nums.size() / 2;
        for (int i = length - 1; i >= 0; i--) {
            TreeNode treeNode = treeNodes.get(i);
            treeNode.left = treeNodes.get(2 * i + 1);
            treeNode.right = treeNodes.get(2 * i + 2);
            treeNodes.add(i, treeNode);
        }
        return treeNodes.get(0);
    }

    public int findTilt(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        return sumLeft + sumRight + root.val;
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode NULL = new TreeNode();
        TreeNode() {super();}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
