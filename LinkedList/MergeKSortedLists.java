package LinkedList;
/**
 * using min heap
 * time complexity: O(nlogk) - The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue.
 * But finding the node with the smallest value just costs O(1)O(1) time.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        // add all the values to a min heap
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        
        // remove values from minheap and create the linkedlist
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while (!minHeap.isEmpty()) {
            int val = minHeap.remove();
            ListNode temp = new ListNode(val);
            prev.next = temp;
            prev = prev.next;
        }
        
        prev.next = null;
        return dummy.next;
        
    }
}
//-----------------------------------------
/**
 * Merge lists one by one
 * time complexity: O(kN) where k is the number of linked lists
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        // merge list 2 by 2
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        
        while (l1 != null && l2 != null) {
            
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next; 
            } 
            
            pre = pre.next;
        }
        
        if (l1 != null) pre.next = l1;
        if (l2 != null) pre.next = l2;
        
        return dummy.next;
    }  
}
//-----------------------------------------
/**
 * Merge with Divide And Conquer
 * time complexity: O(Nlogk) where k is the number of linked lists.
 */
class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        // divide and conqure
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i]= mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];    
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        
        while (l1 != null && l2 != null) {
            
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next; 
            } 
            
            pre = pre.next;
        }
        
        if (l1 != null) pre.next = l1;
        if (l2 != null) pre.next = l2;
        
        return dummy.next;
    }  
}
// ----------------------------------------------
/**
 * Merge with Divide And Conquer - EASIER WAY
 * time complexity: O(Nlogk) where k is the number of linked lists.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) return null;
        
        // while the list has not shrink to only one element
        while (lists.length > 1) {
            
            List<ListNode> temp = new ArrayList<>();
            
            // merge elements 2 by 2
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                ListNode result = mergeTwoLists(l1, l2);
                temp.add(result);
            }
            // reasign the lists variable to the merged list 
            lists = temp.toArray(new ListNode[temp.size()]);
    
        }
        
        return lists[0];
  
    }
    
    // merges 2 sorted list
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
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
        
        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}