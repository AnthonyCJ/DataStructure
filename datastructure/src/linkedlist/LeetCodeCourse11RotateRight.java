package linkedlist;

public class LeetCodeCourse11RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        // mod k
        ListNode getNumNode = head;
        int n = 0;
        while (getNumNode != null) {
            n++;
            getNumNode = getNumNode.next;
        }
        k %= n;
        if (k == 0) return head;
        // find the part to rotate
        ListNode fastNode = head, slowNode = head;
        while (k > 0) {
            fastNode = fastNode.next;
            k--;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // cut and link
        fastNode.next = head;
        ListNode newHead = slowNode.next;
        slowNode.next = null;
        return newHead;
    }
}
