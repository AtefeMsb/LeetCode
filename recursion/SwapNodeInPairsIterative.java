package recursion;

class SwapNodeInPairsIterative {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            
            ListNode first = head;
            ListNode second = head.next;
            
            // swap
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = head;
            head = head.next;
            
        }
        
        return dummy.next;     
    }
}
// simpler to understand
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        // swap head and second
        ListNode second = head.next;
        head.next = second.next;
        second.next = head;
        head = second;
        
        // swap the rest of the nodes
        ListNode node = head.next.next;
        ListNode prev = head.next;
        
        while (node != null && node.next != null) {
            
            ListNode nextNode = node.next;
            
            prev.next = nextNode;
            node.next = nextNode.next;
            nextNode.next = node;
            
            prev = node;
            node = node.next;
            
        }
        
        return head;
    }
}