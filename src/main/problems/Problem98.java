package main.problems;

import java.util.HashMap;

public class Problem98 {


    HashMap<TreeNode, Integer> minMap = new HashMap<>();
    HashMap<TreeNode, Integer> maxMap = new HashMap<>();

    Integer curMin = Integer.MAX_VALUE;
    Integer curMax = 0;
    public boolean isValidBST(TreeNode root) {
        return (root.left == null || (maxNode(root.left) < root.val && isValidBST(root.left))) && (root.right == null || ( root.val < minNode(root.right) && isValidBST(root.right)));
    }

    public int minNode(TreeNode root) {
        curMin = minMap.get(root);
        if(curMin == null) {
            curMin = root.val;
            curMin = (root.right != null ? Math.min(curMin, minNode(root.right)) : curMin);
            curMin = (root.left != null ? Math.min(curMin, minNode(root.left)) : curMin);
            minMap.put(root, curMin);
        }

        return curMin;
    }

    public int maxNode(TreeNode root) {
        curMax = maxMap.get(root);
        if(curMax == null) {
            curMax = root.val;
            curMax = (root.right != null ? Math.max(curMax, maxNode(root.right)) : curMax);
            curMax = (root.left != null ? Math.max(curMax, maxNode(root.left)) : curMax);
            maxMap.put(root, curMax);
        }

        return curMax;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
