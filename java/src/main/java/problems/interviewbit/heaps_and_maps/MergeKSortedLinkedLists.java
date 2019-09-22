package problems.interviewbit.heaps_and_maps;

import problems.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {


    public ListNode mergeTwoNodes(ListNode node1, ListNode node2){
        ListNode head=null, tail=null;

        while(node1!=null && node2!=null){
            if(node1.val<= node2.val){
                tail=attachNode(tail,node1.val);
                node1=node1.next;
            }
            else{
                tail=attachNode(tail,node2.val);
                node2=node2.next;
            }
            if(head==null)
                head=tail;
        }

        if(node1!=null){
            do{
                tail=attachNode(tail,node1.val);
                node1=node1.next;
            }while(node1!=null);
        }
        else{
            do{
                tail=attachNode(tail,node2.val);
                node2=node2.next;
            }while(node2!=null);
        }



        return head;
    }

    public ListNode attachNode(ListNode tail, int first){
        ListNode firstNode = new ListNode(first);
        if(tail==null)
            tail = firstNode;
        else{
            tail.next= firstNode;
            tail = firstNode;
        }
        return tail;
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode mergedNode=a.get(0);
        for(int i=1; i< a.size(); i++){
            mergedNode = mergeTwoNodes(mergedNode,a.get(i));
        }
        return mergedNode;
    }

    public static void main(String[] args) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode first= new ListNode(1);
        first.next= new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);

        ListNode second= new ListNode(2);
        second.next= new ListNode(3);
        second.next.next = new ListNode(4);
        second.next.next.next = new ListNode(5);

        ListNode third= new ListNode(3);
        third.next= new ListNode(4);
        third.next.next = new ListNode(5);
        third.next.next.next = new ListNode(6);
        System.out.println(new MergeKSortedLinkedLists().mergeKLists(
                new ArrayList<>(Arrays.asList(first,second,third))));
    }
}
