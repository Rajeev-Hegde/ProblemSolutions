package problems.interviewbit.codeninja;

import problems.TreeNode;

public class BuildIdenticalTrees {


    public int iterateAndCount(TreeNode A, TreeNode B, int currentNumber){

//        if(A==null && B==null)
//            return currentNumber;
        if(A==null && B== null)
            return currentNumber;

        else if(B==null)
            return -1;
        else if(A==null) {
            currentNumber += 1;
            currentNumber= iterateAndCount(null,B.left, currentNumber);
            currentNumber = iterateAndCount(null, B.right, currentNumber);
        }else {
            if (currentNumber != -1)
                currentNumber = iterateAndCount(A.left, B.left, currentNumber);
            if (currentNumber != -1)
                currentNumber = iterateAndCount(A.right, B.right, currentNumber);
        }
        return currentNumber;
    }


    public int cntMatrix(TreeNode A, TreeNode B) {
        return iterateAndCount(A,B, 0);
    }

    public static void main(String[] args) {


        TreeNode treeNode1= new TreeNode(1);
        treeNode1.left=new TreeNode(2);
        treeNode1.left.left=new TreeNode(3);
        treeNode1.left.left.left=new TreeNode(4);

        TreeNode treeNode2= new TreeNode(1);
        treeNode2.left=new TreeNode(2);
        treeNode2.left.left=new TreeNode(3);
        treeNode2.left.left.left=new TreeNode(4);
        treeNode2.left.left.left.left=new TreeNode(5);
        treeNode2.left.left.left.left.right=new TreeNode(6);
        treeNode2.right=new TreeNode(7);

        System.out.println(new BuildIdenticalTrees().cntMatrix(treeNode1,treeNode2));
    }
}
