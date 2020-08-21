package LinkedList;

/*
This problem is a combination of these three easy problems:

Middle of the Linked List.

Reverse Linked List.

Merge Two Sorted Lists.
*/

class ReorderList {
    public void reorderList(ListNode head) {
      if (head == null) return;
  
      // find the middle of linked list [Problem 876]
      // in 1->2->3->4->5->6 find 4 
      // slow pointer will stop on the middle
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
  
      // reverse the second part of the list [Problem 206]
      // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
      // reverse the second half in-place
      ListNode prev = null;
      ListNode curr = slow;
      ListNode tmp;
        
      while (curr != null) {
        tmp = curr.next;
          
        curr.next = prev;
        prev = curr;
        curr = tmp;
      }
        
      // prev will be the head of the reversed second part
  
      // merge two sorted linked lists [Problem 21]
      // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
      ListNode first = head;
      ListNode second = prev;
        
      while (second.next != null) {
        tmp = first.next;
        first.next = second;
        first = tmp;
  
        tmp = second.next;
        second.next = first;
        second = tmp;
      }
    }
  }