package main.assessments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    HashMap<Integer, Integer> depthTotal = new HashMap<>();
    HashMap<TreeNode, Integer> depthChart = new HashMap<>();
    LinkedList<TreeNode> toVist = new LinkedList<>();
    Integer runningMax = 0;
    int maxDepth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }

        toVist.add(root);
        depthChart.put(root, 0);

        TreeNode curNode = null;
        int curDepth = 0;
        while(toVist.size() != 0) {
            System.out.println(runningMax);
            curNode = toVist.pop();
            curDepth = depthChart.get(curNode);

            if (curNode.left != null || curNode.right != null) {
                maxDepth = Math.max(maxDepth, curDepth + 1);
                if(depthTotal.get(curDepth + 1) == null) {
                    depthTotal.put(curDepth + 1, 2);
                    runningMax = Math.max(runningMax, depthTotal.get(curDepth + 1));
                } else {
                    depthTotal.put(curDepth + 1, depthTotal.get(curDepth + 1) + 2);
                    runningMax = Math.max(runningMax, depthTotal.get(curDepth + 1));
                }

                if(curNode.left != null) {
                    depthChart.put(curNode.left, curDepth + 1);
                    toVist.add(curNode.left);
                }

                if(curNode.right != null) {
                    depthChart.put(curNode.right, curDepth + 1);
                    toVist.add(curNode.right);
                }
            }
        }
        return (int)Math.pow(2, maxDepth);
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
