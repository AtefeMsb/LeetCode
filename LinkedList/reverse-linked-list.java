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
