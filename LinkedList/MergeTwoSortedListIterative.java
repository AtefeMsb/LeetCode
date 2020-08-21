package LinkedList;

// Time complexity : O(n + m)
// Space complexity : O(1)

class MergeTwoSortedListIterative {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // dummy and prev points at the pre head
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while (l1 != null && l2 != null) {
            
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            
            // prev points at the tail of the merged list
            prev = prev.next;
        }
        
        // attach the rest of unfinished list to the merged list
        prev.next = (l1 == null) ? l2 : l1;
        
        return dummy.next;
    }
}