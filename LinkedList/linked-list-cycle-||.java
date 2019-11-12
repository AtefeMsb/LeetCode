 // https://leetcode.com/articles/linked-list-cycle-ii/
 // Floyd's Tortoise and Hare
public class Solution {
    public ListNode getIntersect(ListNode head) {
         if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;   
    }
    
    public ListNode detectCycle(ListNode head) {
        
        ListNode intersect = getIntersect(head);
        if (intersect == null) { return null;}
        
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        
        // distance between head and begining of the cycle
        // EQUALS
        // distance between intersection and begining of the cycle
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1; 
    }
}
