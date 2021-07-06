package linkedlist;

public class LeetCodeCourse9MergeTwoLists {
    /**
     * Iteration
     * Time:O(m+n), Space:O(1)
     * Version 1.0 2021-07-05 XCJ committed
     * @param l1 head of list1
     * @param l2 head of list2
     * @return head node after merge
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        // 创建虚拟头节点，工作指针初始化指向头节点
        ListNode dummyHead = new ListNode(0);
        ListNode preNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            }
            else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        // 将剩余链表直接连接至新链表表尾
        preNode.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    /**
     * Recursion
     * Time:O(m+n), Space:O(n)
     * Version 1.0 2021-07-06 by LeetCode
     * @param l1 head of list1
     * @param l2 head of list2
     * @return head node after merge
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next =  mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next =  mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
