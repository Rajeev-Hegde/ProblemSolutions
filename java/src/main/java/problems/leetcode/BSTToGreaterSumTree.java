package problems.leetcode;


import problems.interviewbit.trees.TreeNode;

/**
 * Given the root of a binary search tree with distinct values,
 * modify it so that every node has a new value equal to the sum of the values of the
 * original tree that are greater than or equal to node.val.
 *
 *
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class BSTToGreaterSumTree {


    private int currentSum=0;

    private TreeNode bstToGst(TreeNode root) {

        if(root.right!=null)
            bstToGst(root.right);
        currentSum+=root.val;
        root.val = currentSum;
        if(root.left!=null)
            bstToGst(root.left);
        return root;
    }
}
