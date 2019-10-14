package problems.leetcode.top_interview_questions.easy;

import problems.TreeNode;

/**
 * IMPORTANT
 */
public class SumOfRootToLeafOfBT {
    public int sumRootToLeaf(TreeNode root) {
        return traverse(root, 0);
    }

    public int traverse(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + num;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = traverse(root.left, sum << 1);
        int right = traverse(root.right, sum << 1);
        sum =  left + right;
        return sum;
    }
}
