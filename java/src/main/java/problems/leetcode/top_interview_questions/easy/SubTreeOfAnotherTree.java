package problems.leetcode.top_interview_questions.easy;

import problems.TreeNode;

/**
 * IMPORTANT
 */
public class SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null)
            return false;
        if(s.val == t.val){
            boolean compareRes=compareTrees(s,t);
            if(compareRes)
                return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    public boolean compareTrees(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s==null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return compareTrees(s.left,t.left) && compareTrees(s.right,t.right);

    }

    public static void main(String[] args) {

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right  = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(new SubTreeOfAnotherTree().isSubtree(s,t));
    }

}
