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

// -----------------------------------------------------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode left = dummy;
        // n + 1 step away
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
            
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        
        // now the left is on previous node to be deleted
        left.next = left.next.next;
        
        
        return dummy.next;
    }
}

// ----------------------------------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int count = 0;
        ListNode cur = head;
        
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        
        // edge case when the first element needs to be removed
        if (count == n) {
            return head.next;
        }
        
        int nodeToRemoveIndex = count - n - 1;
        cur = head;
        
        for (int i = 0; i < nodeToRemoveIndex; i++) {
            cur = cur.next;
        }
        
        cur.next = cur.next.next;
        
        return head;
    }
}
