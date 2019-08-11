package problems.interviewbit.linkedlists;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode newNode=null, tail=null;

        while(A!=null || B!=null){
            ListNode newNodeToAttach;
            if(A!=null && B!=null){
                if(A.val<= B.val){
                    newNodeToAttach = new ListNode(A.val);
                    A= A.next;
                }
                else{
                    newNodeToAttach = new ListNode(B.val);
                    B= B.next;
                }
            }
            else if(A!=null){
                newNodeToAttach = new ListNode(A.val);
                A= A.next;
            }
            else{
                newNodeToAttach = new ListNode(B.val);
                B= B.next;
            }

            if(newNode==null){
                newNode = newNodeToAttach;
                tail= newNodeToAttach;
            }
            else{
                tail.next=newNodeToAttach;
                tail= newNodeToAttach;
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        ListNode node1= new ListNode(7);
        node1.next = new ListNode(12);
        node1.next.next = new ListNode(22);

        ListNode node2 = new ListNode(12);
        node2.next = new ListNode(22);
        node2.next.next = new ListNode(27);

        new MergeTwoSortedLists().mergeTwoLists(node1,node2);
    }
}
