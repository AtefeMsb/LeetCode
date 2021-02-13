class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if (head == null) return head;
        
        // dummy node is needed for when the first elements get deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            // if we found the value
            if (cur.val == val) {
                // remove the node, by adjusting the prev next pointer 
                prev.next = cur.next;
                // also updating the cur pointer to the new next node
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
        
    }
}