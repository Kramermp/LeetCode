package main.problems;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem104 {
/*
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

    LinkedList<TreeNode> toBeChecked = new LinkedList<>();
    HashMap<TreeNode, Integer> depthChart = new HashMap<>();
    TreeNode curNode = null;
    int curDepth  = 0;
    int curMax = 1;
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        toBeChecked.add(root);
        depthChart.put(root, 1);

        while(!toBeChecked.isEmpty()) {
            curNode = toBeChecked.pop();
            curDepth = depthChart.get(curNode);
            if(curNode.left != null) {
                toBeChecked.add(curNode.left);
                depthChart.put(curNode.left, curDepth + 1);
                curMax = Math.max(curMax, curDepth + 1);
            }
            if(curNode.right != null) {
                toBeChecked.add(curNode.right);
                depthChart.put(curNode.right, curDepth + 1);
                curMax = Math.max(curMax, curDepth + 1);
            }

        }

        return curMax;
    }

    /**
     * Definition for a binary tree node.
     */
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
