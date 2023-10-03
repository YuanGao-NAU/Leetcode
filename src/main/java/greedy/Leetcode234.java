package greedy;

public class Leetcode234 {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;
        if(head.next == null) return false;

        ListNode temp1 = head;
        ListNode temp2 = head;

        while(temp2 != null && temp2.next != null) {
            temp2 = temp2.next.next;
            temp1 = temp1.next;
        }
        head = reverse(head, temp1);
        return is(head, temp1);
    }

    public boolean is(ListNode headA, ListNode headB) {
        while(headB != null) {
            if(headA.val != headB.val) {
                return false;
            }

            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode next;

        while(head != end) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        Leetcode234 leetcode234 = new Leetcode234();
        leetcode234.isPalindrome(head);
    }
}
