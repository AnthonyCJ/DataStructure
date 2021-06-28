package linkedlist;

public class LeetCodeCourse4DeleteNthFromBottom {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        // p1 points at the predecessor of the node to be deleted
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
            if (p2 == null) return head.next;
        }
        // find the tail
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // delete p1
        p1.next = p1.next.next;

        return head;
    }
}
