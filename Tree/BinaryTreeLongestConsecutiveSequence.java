/**
 * preorder DFS
 * O(n)
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        // to save the max length through all the recursive calls
        int[] max = new int[1];
        dfs(root, max, 0, 0);
        return max[0];
    }
    
    public void dfs(TreeNode root, int[] max, int curLength, int target) {
        
        // reach a leaf and need to return
        if (root == null) {
            return;
        }
        
        // if we found the next piece in sequence, add 1 to curLength
        if (root.val == target) {
            curLength++;
        // if we DID NOT find the next piece in sequence, reset the curLength to 1
        } else {
            curLength = 1;
        }
        
        // update the max with the new curLength
        max[0] = Math.max(max[0], curLength);
        
        dfs(root.left, max, curLength, root.val + 1);
        dfs(root.right, max, curLength, root.val + 1);
    
    }
    
    
}