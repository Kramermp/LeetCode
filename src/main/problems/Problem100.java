package main.problems;

import main.common.TreeNode;

public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return p == q;
    }
}
