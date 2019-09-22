package problems.leetcode.top_interview_questions;

import problems.interviewbit.trees.TreeNode;

public class BinaryTreeMinDepth {

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return ((left!=0 && right!=0)? Math.min(left,right):Math.max(left,right)) +1;
    }
}
