package greedy;

public class Leetcode24 {

    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode temp1 = dummy;
        temp1.next = head;
        ListNode temp2 = head;
        ListNode temp3 = head;
        while(temp1 != null && temp1.next != null && temp1.next.next != null) {
            temp2 = temp1.next;
            temp3 = temp2.next;
            temp2.next = temp3.next;
            temp3.next = temp2;
            temp1.next = temp3;
            temp1 = temp1.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode24 leetcode24 = new Leetcode24();
        leetcode24.swapPairs(leetcode24.head);
    }
}
