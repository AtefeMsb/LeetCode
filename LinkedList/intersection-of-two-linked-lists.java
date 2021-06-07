/**
 * TWO POINTERS
 * time complexity O(N + M)
 * N: length of list A
 * M: length of list B
 * space complexity: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // both pA and pB travel the same amount of nodes
        // after each travel its own list, will start from the head of the other
        // eventually they meet if there is an intersection node

        // if intersection was not found (both pointers null) or found (both pointers on intersection), both pointer will be equal and the loop will end
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

/**
 * HASH SET
 * time complexity O(N + M)
 * N: length of list A
 * M: length of list B
 * space complexity: O(M) for hash set
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) return null;
        
        // put all the nodes from B in a hashset
        Set<ListNode> set = new HashSet<>();
        while (headB != null) {
            set.add(headB);
            headB = headB.next;
        }
        
        // 2. check all nodes in list A to see if they already exists in hashset for B
        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            } 
            headA = headA.next;
        }
        
        // 3. intersection was not found
        return null;
    }
}