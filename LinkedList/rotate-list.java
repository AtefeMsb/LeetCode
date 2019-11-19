/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;
        
        // 1-count the number of nodes and get the tail node
        ListNode cur = head;
        int n = 1;
        while (cur != null && cur.next != null) {
            n += 1;
            cur = cur.next;
        }
        
        // 2- Find the old tail and connect it with the head - create a loop
        cur.next = head;
        
        // 3- in case k > n do this always k = k % n
        k = k % n;
        
        // 4- find the new tail n - k - 1
        int newTailLocation = n - k - 1;
        cur = head;
        for (int i = 0; i < newTailLocation; i++) {
            cur = cur.next;
        }
        ListNode newTail = cur;
        
        // 5- find the new head n - k
        ListNode newHead = cur.next;
        
        // 6- brek the ring 
        newTail.next = null;
        
        return newHead;        
    }
}
