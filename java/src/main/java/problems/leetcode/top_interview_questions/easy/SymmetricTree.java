package problems.leetcode.top_interview_questions.easy;

import problems.TreeNode;

/**
 * IMPORTANT
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSame(root.right, root.left);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val!=q.val)return false;
        return isSame(p.right,q.left) && isSame(p.left,q.right);
    }
}
