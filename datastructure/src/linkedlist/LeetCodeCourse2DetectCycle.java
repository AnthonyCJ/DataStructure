package linkedlist;

public class LeetCodeCourse2DetectCycle {
    /**
     * Solution of double pointers.
     * @param head first node of the list
     * @return ListNode-entry node of the cycle | null-no cycle
     */
    public ListNode detectCycle(ListNode head) {
        // invalid conditions
        if (head == null || head.next == null) return null;

        // find the point that fast and slow meet for the first time
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        // now the distance between head and entry is the same as the distance between slow and entry
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
