package problems.leetcode.medium;

import problems.TreeNode;

import java.util.Stack;


/**
 * Space efficient solution (Other than considering stack space occupied due to recursive operation)
 */
public class BSTIterator {

    Stack<Integer> stack = new Stack<>();


    private void parseTree(TreeNode root, Stack<Integer> tempStack){
        if(root==null){
            stack=tempStack;
        }
        else{
            if(root.right!=null)
                parseTree(root.right, tempStack);
            tempStack.push(root.val);
            if(root.left!=null)
                parseTree(root.left, tempStack);
            stack=tempStack;
        }
    }


    public BSTIterator(TreeNode root) {
        parseTree(root, new Stack<>());
    }

    /** @return the next smallest number */
    public int next() {
        int val= stack.peek();
        stack.pop();
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

}

/**
 * Time efficient solution.
 */
class BSTIteratorFastest{
    Stack<TreeNode> stack;
    public BSTIteratorFastest(TreeNode root) {
        stack = new Stack<>();
        toLeftMost(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        if(curr.right != null){
            toLeftMost(curr.right);
        }
        return curr.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void toLeftMost(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}