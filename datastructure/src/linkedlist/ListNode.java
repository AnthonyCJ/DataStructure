package linkedlist;

/**
 * Node of the LinkedList
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class MyLinkedList {
    int size;   // number of the elements
    ListNode head;  // sentinel node as pseudo-head

    /**
     * Default constructor of LinkedList.
     */
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     * @param index Index of node to return its value.
     * */
    public int get(int index) {
        // if the index is invalid
        if (index < 0 || index >= this.size)
            return -1;

        ListNode curr = head;
        // index steps needed to move from sentinel node to wanted index
        for (int i = 0; i < index + 1; i++) curr = curr.next;
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index < 0) index = 0;

        size++;
        // fine predecessor of the node to be added
        ListNode pre = head;
        for (int i = 0; i < index; i++) pre = pre.next;
        ListNode toAdd = new ListNode(val);
        // insertion itself;
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= this.size) return;

        size--;
        // find the predecessor of the node to be deleted
        ListNode pre = head;
        for (int i = 0; i < index; i++) pre = pre.next;
        pre.next = pre.next.next;
    }
}
