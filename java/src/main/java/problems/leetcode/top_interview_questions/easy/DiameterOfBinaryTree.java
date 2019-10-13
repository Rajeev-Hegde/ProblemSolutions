package problems.leetcode.top_interview_questions.easy;

import problems.TreeNode;

/**
 * IMPORTANT
 */
public class DiameterOfBinaryTree {

    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result=1;
        depth(root);
        return result-1;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;

        int leftLength = depth(root.left);
        int rightLength = depth(root.right);
        result = Math.max(result, leftLength+rightLength+1);
        return Math.max(leftLength, rightLength)+ 1;
    }
}
