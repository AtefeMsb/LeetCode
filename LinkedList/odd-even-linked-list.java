class Solution {
    public ListNode oddEvenList(ListNode head) {
     
        if (head == null ) {return null;}
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        // create two linkedlist
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        // attach even linkedlist to odd linkedlist
        odd.next = evenHead;
        return head;
    }
}
