package problems.interviewbit.linkedlists;

import com.google.gson.Gson;

public class PartitionList {


    public ListNode partition(ListNode A, int B) {

        ListNode partition1=null,initial1=null, initial2=null;
        ListNode partition2=null;

        while (A!=null){
            ListNode temp=A;
            A=A.next;
            temp.next=null;
            if(temp.val < B){
                if(partition1==null) {
                    partition1 = temp;
                    initial1=temp;
                }
                else {
                    partition1.next = temp;
                    partition1=partition1.next;
                }
            }
            else{
                if(partition2==null) {
                    partition2 = temp;
                    initial2=temp;

                }
                else {
                    partition2.next = temp;
                    partition2=partition2.next;
                }
            }
        }
        if(partition1!=null) {
            partition1.next = initial2;
            return initial1;
        }else
            return initial2;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        System.out.println(new Gson().toJson(new PartitionList().partition(A,1)));
    }
}
