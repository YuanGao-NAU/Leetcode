package greedy;

public class Leetcode148 {

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode end) {
        if(head == null || head == end) return null;
        if(head.next == null || head.next == end) {
            head.next = null;
            return head;
        }
        if(head.next.next == null || head.next.next == end) {
            if(head.val > head.next.val) {
                ListNode temp = head.next;
                head.next.next = head;
                head.next = null;
                return temp;
            } else {
                head.next.next = null;
                return head;
            }
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast != end &&
                fast.next != null && fast.next != end &&
                fast.next.next != null && fast.next.next != end
        ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, end);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(left != null && left != slow &&
                right != null && right != end
        ) {
            if(left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if(left != null && left != slow) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode res = Leetcode148.sortList(head);
        System.out.println();
    }
}
