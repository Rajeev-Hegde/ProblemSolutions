package problems.interviewbit.trees;

import java.util.HashMap;
import java.util.Map;

public class BottomView {


    int min=0;
    int max= 0;

    public int iterateAndGetBottomNodeDetails(Node root,
                                               Map<Integer,Integer> distanceVsBottomNodes,
                                               int distanceFromTop){

        if(root==null)
            return distanceFromTop-1;



        iterateAndGetBottomNodeDetails(root.right,
                distanceVsBottomNodes,distanceFromTop+1);
        iterateAndGetBottomNodeDetails(root.left,
                distanceVsBottomNodes,distanceFromTop-1);
        distanceVsBottomNodes.putIfAbsent(distanceFromTop, root.data);
        if(distanceFromTop> max)
            max=distanceFromTop;
        else if(distanceFromTop< min)
            min = distanceFromTop;
        return distanceFromTop+1;

    }

    public void bottomView(Node root) {
        Map<Integer,Integer> distanceVsBottomNodes = new HashMap<>();
        iterateAndGetBottomNodeDetails(root,distanceVsBottomNodes,0);
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

    }
}
