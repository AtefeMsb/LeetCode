 // BFS
 public int maxDepth(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return 0;
        }
        
        int level = 0;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                TreeNode cur = queue.poll();
                if (cur.left != null) { queue.offer(cur.left); }
                if (cur.right != null) { queue.offer(cur.right); }
                
            }
            
            level++;
        }
        
        return level;    
    }
    
//-----------------------------------------------------------------------------------------------------
// recursive - "Bottom-up" Solution - DFS - Movie theatre analogy
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
    
//-----------------------------------------------------------------------------------------------------
// iterative - using 2 stacks
class Solution {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;
        
        stack.push(root);
        depths.push(1);
        
        // total maximum depth
        int maxDepth = 0;
     
        while (!stack.isEmpty()) {
            
            TreeNode node = stack.pop();
            int currentDepth = depths.pop();
            
            // add the children, if the node is not null
            if (node != null) {
                maxDepth = Math.max(maxDepth, currentDepth);
                stack.push(node.left);
                stack.push(node.right);
                depths.push(currentDepth + 1);
                depths.push(currentDepth + 1);
            }
        }
        
        return maxDepth;
    }
}
