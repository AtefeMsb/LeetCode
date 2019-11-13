class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // slow node must stop at previous node of the node we want to delete
        // so the distance between slow and fast node must be n + 1
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        // diffrence between slow and fast is n + 1
        // when fast reach the null means slow is n + 1 steps behind
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
      
        // deletion
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
