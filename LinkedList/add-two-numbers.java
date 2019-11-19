class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null) ? l1.val : 0; 
            int l2Val = (l2 != null) ? l2.val : 0; 
            
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int lastDigit = sum % 10;
            
            ListNode node = new ListNode(lastDigit);
            cur.next = node;
            cur = cur.next;
            
            if (l1 != null) {l1 = l1.next;}
            if (l2 != null) {l2 = l2.next;}
        }
          
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }

        return dummy.next;
    }
}
