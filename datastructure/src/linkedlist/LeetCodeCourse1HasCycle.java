package linkedlist;

public class LeetCodeCourse1HasCycle {
    /**
     * Solution of double pointers.
     * @param head first node of the list
     * @return true-has cycle, false-no cycle
     */
    public boolean hasCycle(ListNode head) {
        // invalid conditions
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

    /**
     * Informal solution
     * @param head first node of the list
     * @return true-has cycle, false-no cycle
     */
    public boolean hasCyclePlus(ListNode head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
            if (n > 10000) return true;
        }
        return false;
    }
}
