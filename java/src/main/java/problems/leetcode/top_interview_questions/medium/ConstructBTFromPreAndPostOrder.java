package problems.leetcode.top_interview_questions.medium;

import problems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConstructBTFromPreAndPostOrder {

//    public TreeNode insertLevelOrder(int[] arr, TreeNode root,
//                                 int i)
//    {
//        // Base case for recursion
//        if (i < arr.length) {
//            TreeNode temp = new TreeNode(arr[i]);
//            root = temp;
//            root.left = insertLevelOrder(arr, root.left,
//                    2 * i + 1);
//
//            root.right = insertLevelOrder(arr, root.right,
//                    2 * i + 2);
//        }
//        return root;
//    }
//    public static TreeNode createTree(Integer[] array) {
////        if (array == null || array.length==0) {
////            return null;
////        }
////
////        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
////        Queue<Integer> integerQueue = new LinkedList<>();
////        for (int i = 1; i < array.length; i++) {
////            integerQueue.offer(array[i]);
////        }
////
////        TreeNode treeNode = new TreeNode(array[0]);
////        treeNodeQueue.offer(treeNode);
////
////        while (!integerQueue.isEmpty()){
////            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
////            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
////            TreeNode current = treeNodeQueue.poll();
////            if (leftVal !=null) {
////                TreeNode left = new TreeNode(leftVal);
////                current.left = left;
////                treeNodeQueue.offer(left);
////            }
////            if (rightVal !=null){
////                TreeNode right = new TreeNode(rightVal);
////                current.right = right;
////                treeNodeQueue.offer(right);
////            }
////        }
////        return treeNode;
////    }
////
////    public TreeNode constructFromPrePost(int[] pre, int[] post) {
////        TreeNode root=null;
////        Integer[] res = new Integer[2*pre.length];
////        int resPos=0;
////        Queue<Integer> queue= new LinkedList<>();
////        Stack<Integer> stack = new Stack<>();
////        int i=0, j=0;
////        while(i< pre.length && j< post.length){
////            if(!stack.isEmpty() && stack.peek()== post[j]){
////                j++;
////                stack.pop();
////                continue;
////            }
////            if(pre[i]== post[j]){
////                queue.add(pre[i]);
////                i++;
////                j++;
////            }
////            else{
////                res[resPos++]= pre[i];
////                stack.add(pre[i]);
////                i++;
////            }
////        }
////
////        while(!stack.isEmpty()){
////            stack.pop();
////            res[resPos++] = null;
////        }
////
////        while(!queue.isEmpty()){
////            res[resPos++]= queue.poll();
////        }
////        return createTree(res);
////    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length-1,0, post.length-1);
    }


    public TreeNode constructFromPrePost(int[] pre, int[] post,int preStart,int preEnd, int postStart, int postEnd) {
        if(preStart>preEnd){
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        if(preStart != preEnd){
            int next = pre[preStart+1];
            int count = 0;
            for(int i = postStart; i<postEnd; i++){
                count++;
                if(next == post[i]){
                    break;
                }
            }
            root.left = constructFromPrePost(pre,post,preStart+1,preStart+count,postStart, postStart+count-1);
            root.right = constructFromPrePost(pre, post,preStart+count+1,preEnd,postStart+count,postEnd-1 );
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root= new ConstructBTFromPreAndPostOrder()
                .constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
        System.out.println(root);
    }
}
