/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        
        // 1. find the last 9 node, have a notNine poiter one node before
        // 2. add one to notNine node
        // 3. change anything after the 9 to zero
        
        // in case of 999 that changes to 1000, we need an extra node at the begining of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode notNine = dummy;
        
        while (head != null) {
            
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }
        
        notNine.val++;
        notNine = notNine.next;
        
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        // if the dummy node was not used, we can return whatever comes after
        return dummy.val == 0 ? dummy.next : dummy;
    }
}