package problems.leetcode.top_interview_questions;

import problems.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeleteNodesAndReturnForest {


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = IntStream.of(to_delete)
                .boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        if(!delNodes(root, toDelete, result))
            result.add(root);
        return result;
    }
    private boolean delNodes(TreeNode current, Set<Integer> toDelete, List<TreeNode> newRootNodes) {
        if (current == null)
            return false;
        if(delNodes(current.left, toDelete, newRootNodes))
            current.left = null;
        if(delNodes(current.right, toDelete, newRootNodes))
            current.right = null;
        if (toDelete.contains(current.val)){
            if(current.left != null)
                newRootNodes.add(current.left);
            if(current.right != null)
                newRootNodes.add(current.right);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode= new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left= new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left= new TreeNode(6);
        treeNode.right.right= new TreeNode(7);
        System.out.println(new DeleteNodesAndReturnForest().delNodes(treeNode,new int[]{1}));
    }
}
