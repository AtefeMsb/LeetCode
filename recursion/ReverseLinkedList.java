package recursion;

// iterative solution
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            
            // save the next node to not loosing it
            ListNode next = cur.next;
            // reverse the link
            cur.next = prev;
            
            // advance the pointers
            prev = cur;
            cur = next;
        }
        
        return prev; 
    }
}