package TopInterview;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // using dummy node helps with keeping the head of result list
        ListNode dummy = new ListNode();
        ListNode node = dummy; 
        int carry = 0;
        
        // if one of the lists in non-empty
        while (l1 != null || l2 != null) {
            // for simplisity we assume the value exhasuted list is zero 
            int l1val = (l1 != null) ? l1.val : 0;
            int l2val = (l2 != null) ? l2.val : 0;
            
            int sum = l1val + l2val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            
            node.next = new ListNode(remainder);
            node = node.next;
            
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        
        // if both lists were exhausted but still `some carry left
        if (carry != 0) {
            node.next = new ListNode(carry);
            node = node.next;
        }
  
        return dummy.next;
    }
    
}