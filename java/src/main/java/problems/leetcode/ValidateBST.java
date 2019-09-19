package problems.leetcode;

import problems.interviewbit.trees.TreeNode;

public class ValidateBST {


    private long prevVal= Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if(root==null)
            return true;
        if(root.left!=null)
            if(!isValidBST(root.left))
                return false;
        if(root.val<= prevVal)
            return false;
        prevVal=root.val;
        if(root.right!=null)
            if(!isValidBST(root.right))
                return false;
        return true;
    }
}
