package linkedlist;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        // invalid conditions
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = slow.next;
        int n = 0;
        while (slow != fast) {
//            if (n >= 10000) return false;
//            n++;
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
