package problems.leetcode;

import problems.interviewbit.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderUsingStack {

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        while(true)
        {
            while(root!=null)

            {
                st.push(root);
                root=root.left;
            }
            if(st.isEmpty())
                break;
            TreeNode d=st.pop();
            ans.add(d.val);
            root=d.right;
        }
        return ans;
    }
}
