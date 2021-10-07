class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int carry = 0;
        int lastDigit = 0;
        
        while (l1 != null || l2 != null) {
            // in case one of the list finishes early, is shorter
            int l1VAl =  (l1 == null) ? 0 : l1.val;
            int l2VAl =  (l2 == null) ? 0 : l2.val;
            
            int sum = l1VAl + l2VAl + carry;
            carry = sum / 10;
            lastDigit = sum % 10;
            
            ListNode node = new ListNode(lastDigit);
            head.next = node;
            head = head.next;
            
            if (l1 != null) {l1 = l1.next;}
            if (l2 != null) {l2 = l2.next;}
            
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        
        return dummy.next;    
    }
}