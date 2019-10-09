package problems.interviewbit.mock_interviews;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.Queue;

/**
 * IMPORTANT
 */
public class InvertBinaryTree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    public void swap(TreeNode A){
        TreeNode temp=A.left;
        A.left=A.right;
        A.right = temp;
    }

    public TreeNode invertTree(TreeNode A) {

        if(A.left==null && A.right== null)
            return null;

        if(A.left!=null)
            invertTree(A.left);

        if(A.right!=null)
            invertTree(A.right);

        swap(A);
        return A;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left=  new TreeNode(1);
        treeNode.right=  new TreeNode(-1);

        treeNode.left.left=  new TreeNode(-1);
//        treeNode.left.right=  new TreeNode(5);
//
//        treeNode.right.left=  new TreeNode(6);
//        treeNode.right.right=  new TreeNode(7);

        System.out.println(new Gson().toJson(new InvertBinaryTree().invertTree(treeNode)));
    }



    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
    /*
    SWAPS first and then goes inside. Try this solution if above solution dosen't work
    public TreeNode invertTree(TreeNode A) {
        if (A == null) return A;
        swap(A);
        return A;
    }

    public void swap(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode n1 = root.left;
        root.left = root.right;
        root.right = n1;

        if (root.left != null) swap(root.left);
        if (root.right != null) swap(root.right);
    }*/
}
