package problems.interviewbit.trees;

import java.util.ArrayList;

public class InOrderTraversal {

    public void traverse(TreeNode A, ArrayList<Integer> arrayList){
        if(A!=null){
            traverse(A.left,arrayList);
            arrayList.add(A.val);
            traverse(A.right,arrayList);
        }
    }


    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(A, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
