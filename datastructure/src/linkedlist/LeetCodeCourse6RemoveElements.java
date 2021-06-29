package linkedlist;

public class LeetCodeCourse6RemoveElements {
    public ListNode removeElements01(ListNode head, int val) {
        // null list
        if (head == null) return head;
        // clear body (ignore the head)
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                continue;   // This is the key.
            }
            p = p.next;
        }
        // clear head
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * Improved Version
     * @param head head of the list
     * @param val ListNode of val should be deleted
     * @return head
     */
    public ListNode removeElements02(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode p = dummyHead;
        while (p.next != null) {
            if (p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return dummyHead.next;
    }

    /**
     * Recursion Solution
     * @param head head of the list
     * @param val ListNode of val should be deleted
     * @return head
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        // iteration
        head.next = removeElements(head.next, val);
        // handle head
        return head.val == val ? head.next : head;
    }
}
