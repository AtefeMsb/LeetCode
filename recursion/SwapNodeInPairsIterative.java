package recursion;

class SwapNodeInPairsIterative {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            
            ListNode first = head;
            ListNode second = head.next;
            
            // swap
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = head;
            head = head.next;
            
        }
        
        return dummy.next;     
    }
}