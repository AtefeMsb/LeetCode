class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // slow will stop at "middle of the loop + 1"
        // when fast reaches the end of linkedlist, slow will be on the middle element
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // everse the second part of the list
        slow = reverse(slow);
        fast = head;
        
        // compare reversed second part with the first part
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        
        return prev;
    }
}
// -------------------------------
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) return true;
        
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = revereseList(firstHalfEnd.next);
        
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        
        while (result == true && p2 != null) { 
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;                                     
        }
        
        // make the input the same it was
        firstHalfEnd.next = revereseList(secondHalfStart);
        
        return result;
        
    }
    
    private ListNode revereseList(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
    
    private ListNode endOfFirstHalf(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
