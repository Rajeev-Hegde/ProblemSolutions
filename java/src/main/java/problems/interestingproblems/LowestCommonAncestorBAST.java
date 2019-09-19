package problems.interestingproblems;

import problems.BinaryNode;

public class LowestCommonAncestorBAST {


    private static BinaryNode findLCA(BinaryNode node, int n1, int n2){
        if(node==null)
            return null;

        if(node.data > n1 && node.data > n2)
            findLCA(node.left, n1, n2);
        if(node.data < n1 && node.data < n2)
            findLCA(node.right, n1, n2);

        return node;
    }



    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(30);
        node.left = new BinaryNode(20);
        node.left.left = new BinaryNode(10);
        node.left.right = new BinaryNode(25);
        node.right = new BinaryNode(40);

        System.out.println(LowestCommonAncestorBAST.findLCA(node,10,25).data);
    }
}
