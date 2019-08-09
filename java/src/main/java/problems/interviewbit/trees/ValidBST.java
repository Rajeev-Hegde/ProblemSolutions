package problems.interviewbit.trees;

public class ValidBST {


    int isBST(Node root)
    {
        // Your code here

        if(root==null)
            return 1;
        else if(root.left!=null && root.data < root.left.data)
            return 0;
        else if(root.right!=null && root.data >= root.right.data)
            return 0;

        return (isBST(root.left)==1 && isBST(root.right)==1)? 1: 0;
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(10);
        node.left.left = new Node(5);
        node.left.left.left = new Node(2);
        node.left.left.left.right = new Node(3);

        System.out.println(new ValidBST().isBST(node));
    }
}
