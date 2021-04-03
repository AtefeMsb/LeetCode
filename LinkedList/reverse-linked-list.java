/*
the idea of ITERATIVELY reverse a singly linkedlist:
1- always keep track of next node, previous node, and the current node.
2- make curenty node point to the next node as go forward.
3- after changing the link, update the previous node to be the current node and THEN 
update the current node to be the next node.
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            // save the next node to not lose it
            ListNode nextNode = cur.next;
            // connect current node to previous
            cur.next = prev;
            // move prev and curr forward 
            prev = cur;
            cur = nextNode;   
        }
       
       return prev;
    }
}
// ------------------------------
/**
 * recursive
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       return recursive(head, null);
    }
    
    private ListNode recursive(ListNode head, ListNode prev) {
        // base case - reach the end of the list
        if (head == null) return prev;
        
        // advanve prev and head pointers
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        
        // do the same thing on the new advances prev and head pointers
        return recursive(head, prev);
        
    }
}