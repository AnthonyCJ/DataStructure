package linkedlist;

import java.util.Stack;

public class LeetCodeCourse8PalindromeList {
    /**
     * 迭代法反转链表
     * @param head old head of the list
     * @return new head after reversion
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode oldHead = head, ptr = head.next;
        while (oldHead.next != null) {
            // 取出
            oldHead.next = ptr.next;
            // 连接
            ptr.next = head;
            // 更新head
            head = ptr;
            // ptr复位
            ptr = oldHead.next;
        }
        return head;
    }

    /**
     * double pointer to divide the list into two lists
     * Version 1.0 2021-07-03 XCJ committed
     * @param head head of the list
     * @return true it is a palindrome list | false it is not a palindrome list
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slowPtr = head, fastPtr = head.next;
        // find the middle node of the list
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        // reverse the latter-half list
        fastPtr = reverseList(slowPtr.next);
        slowPtr = head;
        // checkout palindrome
        while (slowPtr != null && fastPtr != null) {
            if (slowPtr.val != fastPtr.val) return false;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return true;
    }

    /**
     * Using stack (referring to autoboxing, this method is very slow)
     * Version 1.0 2021-07-03 XCJ committed
     * @param head head of the list
     * @return true it is a palindrome list | false it is not a palindrome list
     */
    public boolean isPalindrome01(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slowPtr = head, fastPtr = head.next;
        Stack<Integer> stack = new Stack<>();

        while (fastPtr != null && fastPtr.next != null) {
            stack.push(slowPtr.val);
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        if (fastPtr != null) stack.push(slowPtr.val);
        slowPtr = slowPtr.next;
        int temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (slowPtr.val != temp) return false;
            slowPtr = slowPtr.next;
        }
        return true;
    }
}
