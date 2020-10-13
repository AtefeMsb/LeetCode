package LinkedList;

// merge sort
// fast and slow pointer
// recursive
public class SortListRecursive {

    public ListNode sortList(ListNode head) {
        
      if (head == null || head.next == null)
        return head;
          
      // step 1. cut the list to two halves
      // list 1:[head...prev], list 2:[slow...fast]
      ListNode prev = null;
      ListNode slow = head;
      ListNode fast = head;
      
      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      
      // end of list one 
      prev.next = null;
      
      // step 2. sort each half
      // left side
      ListNode l1 = sortList(head);
      // right side
      ListNode l2 = sortList(slow);
      
      // step 3. merge l1 and l2
      return merge(l1, l2);
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
       
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          curr.next = l1;
          l1 = l1.next;
        } else {
          curr.next = l2;
          l2 = l2.next;
        }
        curr = curr.next;
      }
      
      if (l1 != null)
        curr.next = l1;
      
      if (l2 != null)
        curr.next = l2;
      
      return dummy.next;
    }
  
  }