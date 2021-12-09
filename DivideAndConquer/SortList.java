/**
 * merge sort
 * time: O(n logn)
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        // empty list or only one node list
        if (head == null || head.next == null) {
            return head;
        }
        
        // splitting
        ListNode slow = head;
        ListNode fast = head;
        // prev is the middle point
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // the middle point next will point to null
        prev.next = null;
        
        // [head ... prev][slow ... fast]
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        
        // merging
        return merge(l1, l2);
        
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        if (l1 == null) head.next = l2;
        if (l2 == null) head.next = l1;
        
        return dummy.next;
    }
}