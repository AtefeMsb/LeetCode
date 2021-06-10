class Solution {
    public void deleteNode(ListNode node) {
        
        // since we don't have the preceding node, we can only copy the next value
        // to the current node and delete the next node.
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}