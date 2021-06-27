package linkedlist;

public class LeetCodeCourse3CrossList {
    /**
     * First commit.
     * @Version 1.0
     * @param headA head of list A
     * @param headB head of list B
     * @return ListNode-point of crossing | null-no crossing point
     */
    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        // get the num of each list
        int nA = 0, nB = 0;
        while (ptrA != null) {
            nA++;
            ptrA = ptrA.next;
        }
        while (ptrB != null) {
            nB++;
            ptrB = ptrB.next;
        }
        ptrA = headA;
        ptrB = headB;
        // justify the two lists
        if (nA > nB) {
            for (int i = 0; i < nA - nB; i++) ptrA = ptrA.next;
            while (ptrA != null) {
                if (ptrA == ptrB) return ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
            return null;
        }
        else if(nA < nB) {
            for (int i = 0; i < nB - nA; i++) ptrB = ptrB.next;
            while (ptrB != null) {
                if (ptrA == ptrB) return ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
            return null;
        }
        else {
            while (ptrA != null) {
                if (ptrA == ptrB) return ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
            return null;
        }
    }

    /**
     * Modified version.
     * @Version 2.0
     * @param headA head of list A
     * @param headB head of list B
     * @return ListNode-point of crossing | null-no crossing point
     */
    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        // invalid situations
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
