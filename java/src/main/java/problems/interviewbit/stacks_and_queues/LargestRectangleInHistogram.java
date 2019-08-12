package problems.interviewbit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {


//    public int largestRectangleArea(ArrayList<Integer> A) {
//        if(A.size()==0)
//            return 0;
//        if(A.size()==1)
//            return A.get(0);
//        int maxArea= A.get(0);
//        int currentAreaMax= A.get(0);
//        int currentMinHeight = A.get(0);
//        int currentTotalLength = 1;
//
//        for(int i=1; i< A.size(); i++){
//            int maxToConsider =Math.min(A.get(i), currentMinHeight)* (currentTotalLength+1);
//            if(maxToConsider >= currentAreaMax && maxToConsider>= Math.min(A.get(i),A.get(i-1))*2){
//                currentAreaMax = Math.min(A.get(i), currentMinHeight)* (currentTotalLength+1);
//                currentMinHeight = Math.min(A.get(i), currentMinHeight);
//                currentTotalLength++;
//            }
//            else if(maxToConsider >= currentAreaMax && maxToConsider< Math.min(A.get(i),A.get(i-1))*2){
//                currentAreaMax=Math.min(A.get(i),A.get(i-1))*2;
//                currentMinHeight = Math.min(A.get(i),A.get(i-1));
//                currentTotalLength=2;
//            }
//            else{
//                currentAreaMax = A.get(i);
//                currentTotalLength=1;
//                currentMinHeight=A.get(i);
//            }
//            maxArea= Math.max(maxArea,currentAreaMax);
//        }
//        return maxArea;
//    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> indexStack = new Stack<>();

        int max_area = 0;
        int stackTop;
        int area_with_top;

        int i = 0;
        while (i < A.size())
        {

            if (indexStack.empty() || A.get(indexStack.peek()) <= A.get(i))
                indexStack.push(i++);
            else
            {
                stackTop = indexStack.peek();
                indexStack.pop();
                area_with_top = A.get(stackTop) * (indexStack.empty() ? i : i - indexStack.peek() - 1);
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (!indexStack.empty())
        {
            stackTop = indexStack.peek();
            indexStack.pop();
            area_with_top = A.get(stackTop) * (indexStack.empty() ? i : i - indexStack.peek() - 1);
            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram()
                .largestRectangleArea(new ArrayList<>
                        (Arrays.asList(65, 19, 8, 39, 14, 21, 83, 87, 95, 11, 14, 58, 11, 90, 34, 96, 34, 62, 96, 38, 58, 57, 12, 78, 57, 60, 7, 58, 56, 49, 36, 67, 69, 30, 74, 46, 97, 62, 47, 42, 43, 98, 60, 32, 39, 75, 69, 28, 35, 52, 89, 78, 4, 26, 65, 21, 39, 89, 87, 69, 48, 60, 6, 21, 5, 98, 52, 59))));
    }
}
