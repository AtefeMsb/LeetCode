package Tree;

/**
 * iterative using BFS
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // swap left and right pointers
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                
            }   
        }
        
        return root;
    }
}
//--------------------------------------------------------
/**
 * recursive - dfs
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    
    private void swap(TreeNode root) {
            
        // base case
        if (root == null) {
            return;
        }
        
        swap(root.left);
        swap(root.right);
        
        // swap the child pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
    }
}

//-----------------------------------------
// another version of recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
            
    }
}

//-----------------------------------------
// another version of recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        // swap the children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}