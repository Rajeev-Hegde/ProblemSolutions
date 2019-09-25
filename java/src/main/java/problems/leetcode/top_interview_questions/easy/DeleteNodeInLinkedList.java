package problems.leetcode.top_interview_questions.easy;

import problems.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Input: head = [4,5,1,9], node = 5
 Output: [4,1,9]
 Explanation: You are given the second node with value 5,
 the linked list should become 4 -> 1 -> 9 after calling your function.
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        ListNode nextNode= node.next;
        ListNode current=node;
        ListNode prev = null;
        while(nextNode!=null){
            prev=current;
            current.val=nextNode.val;
            current = nextNode;
            nextNode=nextNode.next;
        }
        prev.next=null;
    }
}
