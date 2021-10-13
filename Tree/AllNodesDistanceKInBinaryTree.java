/**
 * intuition: see this tree as a graph
 * each node might have a left node, a right node, and a parent node
 */
class Solution {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // 1. using dfs, find parents for each node
        dfs(root, null);
        
        // 2. use bfs to find the k level far nodes from the target
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            
              // if reach to the Kth kevel
            if (level == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                
                // add left
                if (cur.left != null && !seen.contains(cur.left)) { 
                    queue.add(cur.left); 
                    seen.add(cur.left);
                }
                // add right
                 if (cur.right != null && !seen.contains(cur.right)) { 
                    queue.add(cur.right); 
                    seen.add(cur.right);
                }
                // add parent
                TreeNode parent = parents.get(cur);
                if (parent != null && !seen.contains(parent)) {
                    queue.add(parent);
                    seen.add(parent);
                }
            }
            
            level += 1;
            
        }
        
        return new ArrayList<>();
    
    }
    
    // keep all the parent of each node in a hashmap
    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);

    }
}