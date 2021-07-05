package linkedlist;

public class LeetCodeCourse9MergeTwoLists {
    /**
     * Version 1.0 2021-07-05 XCJ committed
     * @param l1 head of list1
     * @param l2 head of list2
     * @return head node after merge
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode preNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            }
            else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}
