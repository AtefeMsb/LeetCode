package LinkedList;

// FAST AN SLOW TECHNIQUE
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            // one step
            slow = slow.next;
            // two steps
            fast = fast.next.next;
        }
        
        // slow will be on the middle when fast reaches the end
        return slow;
    }
}