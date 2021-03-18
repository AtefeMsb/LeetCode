package LinkedList;

// SOLUTION 1: using a HashSet
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}
// TWO POINTER - Floyd's tortoise and hare - Floyd's cycle-finding algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null) {
            return false;
        }
 
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
///////////////////////////////////////////////////
// TWO POINTER - diffrent way
public class Solution3 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}