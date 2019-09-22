package problems.interviewbit.trees;

import problems.TreeNode;

public class MaximumDepth {

    public int maxDepth(TreeNode A) {

        if(A==null)
            return 0;

        int leftDepth= maxDepth(A.left)+1;
        int rightDepth = maxDepth(A.right)+1;

        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode treeNode= new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        System.out.println( new MaximumDepth().maxDepth(treeNode));
    }
}
