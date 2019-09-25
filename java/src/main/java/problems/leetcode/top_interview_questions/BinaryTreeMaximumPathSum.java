package problems.leetcode.top_interview_questions;

import problems.TreeNode;

/**
 Input: [1,2,3]

      1
     / \
     2   3

 Output: 6


 Input: [-10,9,20,null,null,15,7]

     -10
     / \
     9  20
     /  \
     15   7

 Output: 42
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
