package problems.leetcode.mock;

import problems.TreeNode;

public class FlattenBinaryTree {

    TreeNode res = new TreeNode(-1);
    public void flatten(TreeNode root) {
        if(root!= null) {
            TreeNode temp = res;
            constructFlatTree(root, temp);
            root= res.right;
        }
    }

    public void constructFlatTree(TreeNode root, TreeNode pointer){
        if(root!=null){
            TreeNode node = new TreeNode(root.val);
            pointer.right = node;
            pointer.left=null;
            pointer = pointer.right;
            constructFlatTree(root.left, pointer);
            constructFlatTree(root.right, pointer);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode= new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        new FlattenBinaryTree().flatten(treeNode);
    }
}
