package problems.leetcode.top_interview_questions.medium;

import problems.ListNode;

/**
 * IMPORTANT
 */
public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        int carry = updateNumbers(head);
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    private int updateNumbers(ListNode head) {
        if (head == null) {
            return 1;
        }
        int carry = updateNumbers(head.next);
        int sum = head.val + carry;
        head.val = sum % 10;
        return sum>9?  1: 0;
    }
}
