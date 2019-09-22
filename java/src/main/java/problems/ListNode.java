package problems;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; next = null; }

    @Override
    public String toString() {
        String val1 = (next!=null)? next.toString(): "null";
        return "{" +
                "val:" + val +
                ", next:" + val1 +
                '}';
    }
}
