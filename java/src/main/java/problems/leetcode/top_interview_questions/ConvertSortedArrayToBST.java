package problems.leetcode.top_interview_questions;

import problems.TreeNode;

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return bst(nums, 0, nums.length - 1);
    }

    public TreeNode bst(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = bst(num, left, mid - 1);
        node.right = bst(num, mid + 1, right);
        return node;
    }
}
