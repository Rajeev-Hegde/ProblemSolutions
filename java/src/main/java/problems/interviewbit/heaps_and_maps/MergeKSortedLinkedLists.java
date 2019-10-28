package problems.interviewbit.heaps_and_maps;

import problems.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * IMPORTANT
 * https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 */
public class MergeKSortedLinkedLists {


    public ListNode mergeTwoNodes(ListNode node1, ListNode node2){

        if(node1==null && node2==null)
            return null;
        else if(node1== null)
            return node2;
        else if(node2 == null)
            return node1;


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

        if(a.size()==0) return null;

        ListNode mergedNode=a.get(0);
        for(int i=1; i< a.size(); i++){
            mergedNode = mergeTwoNodes(mergedNode,a.get(i));
        }
        return mergedNode;
    }


    public ListNode mergeKListsEfficient(ListNode[] lists) {
        if(lists.length==0) return null;
        while(lists.length!=1){
            int i=0;
            int j=0;
            ListNode[] tempLists = new ListNode[lists.length%2==0? lists.length/2: lists.length/2+1];
            for(;i+1< lists.length; i+=2){
                tempLists[j++] = mergeTwoNodes(lists[i], lists[i+1]);
            }
            if(lists.length%2!=0)
                tempLists[j] = lists[i];
            lists = tempLists;
        }
        return lists[0];
    }

    public static void main(String[] args) {
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
