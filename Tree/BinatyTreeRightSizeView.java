package Tree;

/**
 * level order - bfs
 * time complexity: O(n)
 * spce complexity: O(n)
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightNodes = new ArrayList<>();
        if (root == null) return rightNodes;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // if cur is the last node of this level
                if (i == size - 1) {
                    rightNodes.add(cur.val);
                }
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            
               
        }
        
        return rightNodes;  
    }
}