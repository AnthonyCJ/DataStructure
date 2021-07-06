package linkedlist;

public class LeetCodeCourse10AddTwoNumbers {
    /**
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 1.0 2021-07-06 XCJ committed
     * @param l1 head of list1
     * @param l2 head of list2
     * @return head node after addition
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // initialize head and tool pointer
        ListNode dummyHead = new ListNode(-1);
        ListNode currNode = dummyHead;

        int carry = 0, sum;
        // Iteration
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            currNode.next = new ListNode(sum, null);
            // Iteration
            currNode = currNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // carry left for top digit
        if (carry != 0) currNode.next = new ListNode(carry, null);

        return dummyHead.next;
    }
}
