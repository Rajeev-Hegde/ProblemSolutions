package problems.interviewbit.arrays;

import java.util.*;

public class KthSmallestElement {

    //not efficient solution
    public int kthsmallest(final List<Integer> A, int B) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.addAll(A.subList(0,B));
        for (int i = B; i < A.size(); i++) {
            if(A.get(i)< priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(A.get(i));
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElement().kthsmallest(Arrays.asList(2,1,4,3,2),3));
    }
}
