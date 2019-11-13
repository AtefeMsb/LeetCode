public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // both pA and pB travel the same amount of nodes
        // after each travel its own list, will start from the head of the other
        // eventually they meet if there is an intersectio node
        while (pA != pB) {
            
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            
             if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        
        return pA;   
    }
}
