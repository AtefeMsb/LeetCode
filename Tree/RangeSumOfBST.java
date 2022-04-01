// dfs
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = new int[1];
        dfs(root, low, high, sum);
        return sum[0];
    }
    
    private void dfs(TreeNode root, int low, int high, int[] sum) {
        
        if (root == null) return;
        
        if (root.val >= low && root.val <= high) {
            sum[0] += root.val;
        }
        
        if (root.val >= low) {
            dfs(root.left, low, high, sum);
        }
        
        if (root.val <= high) {
           dfs(root.right, low, high, sum); 
        }
    
    }
}

// --------------------------------------------
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }
    
    private void dfs(TreeNode root, int low, int high) {
        
        if (root == null) return;
        
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        if (root.val >= low) {
            dfs(root.left, low, high);
        }
        
        if (root.val <= high) {
           dfs(root.right, low, high); 
        }
    
    }
}
// ---------------------------------------------
// bfs
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                                
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }
                
                if (node.val >= low && node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.val <= high && node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        return sum;
    }
}