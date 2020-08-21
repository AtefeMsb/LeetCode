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
