package linkedlist;

public class LeetCodeCourse5ReverseList {
    /**
     * 迭代法反转链表
     * @param head old head of the list
     * @return new head after reversion
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        // oldHead指向原head，q指向原oldHead.next
        ListNode oldHead = head, p = oldHead.next;
        while (oldHead.next != null) {
            // 取出
            oldHead.next = p.next;
            // 连接
            p.next = head;
            // 更新head
            head = p;
            // 复位
            p = oldHead.next;
        }
        return head;
    }
}
