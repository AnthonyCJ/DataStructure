package linkedlist;

public class LeetCodeCourse7OddEvenList {
    /**
     * First Commit Version by XCJ 2021-06-30
     * @param head head of the list
     * @return new head of oddEvenList
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even.next != null && even.next.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // if there's still an odd Node left
        if (even.next != null) {
            odd.next = even.next;
            odd.next.next = evenHead;
            even.next = null;
            return head;
        }
        odd.next = evenHead;
        return head;
    }


    /**
     * Modified Version by XCJ 2021-06-30
     * @param head head of the list
     * @return new head of oddEvenList
     */
    public ListNode oddEvenList02(ListNode head) {
        if (head == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // link the EvenList to the OddList
        odd.next = evenHead;
        return head;
    }
}
