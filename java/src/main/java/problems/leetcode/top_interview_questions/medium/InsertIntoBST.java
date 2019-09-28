package problems.leetcode.top_interview_questions.medium;

import problems.TreeNode;

import java.util.*;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        List<Map.Entry<Integer,Integer>> entryList =
                new ArrayList<>(new  HashMap<Integer,Integer>().entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()));

        if(root== null){
            return null;
        }
        else{
            if(root.val> val){
                if(root.left==null){
                    root.left= new TreeNode(val);
                }
                else
                    insertIntoBST(root.left, val);
            }
            if(root.val< val){
                if(root.right==null){
                    root.right= new TreeNode(val);
                }
                else
                    insertIntoBST(root.right,val);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        System.out.println(((int)(Math.random()*1000)%61));
    }
}
