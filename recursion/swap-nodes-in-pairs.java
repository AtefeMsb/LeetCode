// iterative
public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
       
        while (head != null && head.next != null) {
            
            // nodes to be swapped
            ListNode first  = head;
            ListNode second = head.next;
            
           
            // swapping
            pre.next = second;
            first.next = second.next;
            second.next = first;
            
            // Reinitializing the head and pre for next swap
            pre = first;
            head = first.next; // jump 2 steps
        }
    
        return dummy.next;
}

///////////////////////////////////////////////////////////////////////////

// recursive
public ListNode swapPairs(ListNode head) {

    if (head == null || head.next == null) {
        return head;
    }

    // nodes to be swapped
    ListNode first = head;
    ListNode second = head.next;

    // swapping
    first.next = swapPairs(second.next);
    second.next = first;

    // Now the head is the second node
    return second;
}

