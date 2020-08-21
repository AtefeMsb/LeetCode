package LinkedList;

class ReverseLinkedListRecursively {
    public ListNode reverseList(ListNode head) {
        
       // base condition 
        if (head == null || head.next == null) {
            return head;
        }
        
        // traversing to the end of the linkedlist (down down down)
        ListNode reversedListHead = reverseList(head.next);
        // add this node to the reversed list
        head.next.next = head;
        head.next = null;
        // come back up
        return reversedListHead;
        
    }
}