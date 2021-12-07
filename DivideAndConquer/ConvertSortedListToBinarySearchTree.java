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

