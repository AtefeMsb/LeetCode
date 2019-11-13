class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
    
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        // diffrence between slow and fast is n + 1
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
      
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
