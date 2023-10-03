package greedy;

public class Leetcode206 {

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Leetcode206.reverseList(head);
    }
}
