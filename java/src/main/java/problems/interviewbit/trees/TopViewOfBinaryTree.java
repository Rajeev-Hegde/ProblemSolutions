package problems.interviewbit.trees;

import java.util.HashMap;
import java.util.Map;

public class TopViewOfBinaryTree {

    int min=0;
    int max= 0;

    public int iterateAndGetTopNodeDetails(Node root,
                                              Map<Integer,Integer> distanceVsBottomNodes,
                                              int distanceFromTop){

        if(root==null)
            return distanceFromTop;


        distanceVsBottomNodes.putIfAbsent(distanceFromTop, root.data);
        distanceFromTop= iterateAndGetTopNodeDetails(root.right,
                distanceVsBottomNodes,distanceFromTop+1)-1;
        distanceFromTop=iterateAndGetTopNodeDetails(root.left,
                distanceVsBottomNodes,distanceFromTop-1)+1;
        distanceVsBottomNodes.put(distanceFromTop, root.data);
        if(distanceFromTop> max)
            max=distanceFromTop;
        else if(distanceFromTop< min)
            min = distanceFromTop;
        return distanceFromTop;

    }

    public void topView(Node root) {
        Map<Integer,Integer> distanceVsBottomNodes = new HashMap<>();
        iterateAndGetTopNodeDetails(root,distanceVsBottomNodes,0);
        for (int i=min; i<= max; i++){
            if(distanceVsBottomNodes.containsKey(i)) {
                System.out.print(distanceVsBottomNodes.get(i));
                if(i!=max){
                    System.out.print(" ");
                }
            }
        }
    }


    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.left.left = new Node(40);
        node.left.right = new Node(60);
        node.right = new Node(30);
        node.right.left = new Node(90);
        new TopViewOfBinaryTree().topView(node);
    }
}
