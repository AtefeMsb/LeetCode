/** Recursion + Conversion to Array
 * time: O(n)
 * space: O(n)
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // convert the linkedlist to regular list
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        return helper(0, list.size() - 1, list);
    }
    
    public TreeNode helper(int left, int right, List<Integer> list) {
        
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(left, mid - 1, list);
        root.right = helper(mid + 1, right, list);
        
        return root;  
    }
}

// ------------------------------------
/** recursion
 * time: O(nlogn)
 * space: O(logn)
 */

class Solution {

    private ListNode findMiddleElement(ListNode head) {
  
      // The pointer used to disconnect the left half from the mid node.
      ListNode prevPtr = null;
      ListNode slowPtr = head;
      ListNode fastPtr = head;
  
      // Iterate until fastPr doesn't reach the end of the linked list.
      while (fastPtr != null && fastPtr.next != null) {
        prevPtr = slowPtr;
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
      }
  
      // Handling the case when slowPtr was equal to head.
      if (prevPtr != null) {
        prevPtr.next = null;
      }
  
      return slowPtr;
    }
  
    public TreeNode sortedListToBST(ListNode head) {
  
      // If the head doesn't exist, then the linked list is empty
      if (head == null) {
        return null;
      }
  
      // Find the middle element for the list.
      ListNode mid = this.findMiddleElement(head);
  
      // The mid becomes the root of the BST.
      TreeNode node = new TreeNode(mid.val);
  
      // Base case when there is just one element in the linked list
      if (head == mid) {
        return node;
      }
  
      // Recursively form balanced BSTs using the left and right halves of the original list.
      node.left = this.sortedListToBST(head);
      node.right = this.sortedListToBST(mid.next);
      return node;
    }
  }

  // ------------------------------