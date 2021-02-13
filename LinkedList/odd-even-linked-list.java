class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        // keep even list head, to attach it to the tail of odd list at the end
        ListNode evenHead = head.next;
        
        // create an odd list and an even list
        while (even != null && even.next != null) {
            
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        // attach the end of odd list to the begining of even list
        odd.next = evenHead;
        
        // head points to the begining of the odd list, because first node is odd
        return head;
    }
}