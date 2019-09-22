package problems.leetcode.medium;

import problems.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {


    public void constructStack(TreeNode root, List<Integer> list){
        if(root!= null){
            if(root.left!=null)
                constructStack(root.left, list);
            list.add(root.val);
            if(root.right!=null)
                constructStack(root.right, list);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        constructStack(root,list);
        return list.get(k-1);
    }
}
