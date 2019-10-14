package problems.leetcode.top_interview_questions.easy;

import problems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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


    public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            TreeNode leftSub = q.poll();
            TreeNode rightSub = q.poll();
            if(leftSub == null && rightSub == null) continue;
            if(leftSub == null || rightSub == null) return false;
            if(leftSub.val != rightSub.val) return false;
            q.offer(leftSub.left);
            q.offer(rightSub.right);
            q.offer(leftSub.right);
            q.offer(rightSub.left);
        }
        return true;
    }
}
