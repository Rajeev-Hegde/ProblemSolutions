package problems.leetcode.top_interview_questions;

import problems.TreeNode;

public class LongestUniValuePath {

    public int longestUnivaluePath(TreeNode root) {
        int[] res = {0};
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = helper(node.left, res);
        int right = helper(node.right, res);
        int rootWithLeft = 0, rootWithRight = 0;
        if (node.left != null && node.left.val == node.val) {
            rootWithLeft = 1 + left;
        }
        if (node.right != null && node.right.val == node.val) {
            rootWithRight = 1 + right;
        }
        res[0] = Math.max(res[0], rootWithLeft + rootWithRight);
        return Math.max(rootWithLeft, rootWithRight);
    }
}
