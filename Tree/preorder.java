// Iterative - using stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        if (root == null) return output;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            
            TreeNode node = stack.pop();
            output.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
            
        }
        return output;
        
    }
}

// Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        dfsPreorder(root, output);
        return output;        
    }
    
    private void dfsPreorder(TreeNode root, List output) {
        
        if (root == null) {
            return;
        }
        
        output.add(root.val);
        dfsPreorder(root.left, output);
        dfsPreorder(root.right, output);
    }
}