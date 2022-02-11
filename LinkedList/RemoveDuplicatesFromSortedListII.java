class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while (head != null) {
            
            // find the begining of the repeating sequence
            if (head.next != null && head.val == head.next.val) {
                // get all the duplicates in thats sequence
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip the whole repeating sequenece
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            
            head = head.next;   
        }
        
        return dummy.next;
    }
}