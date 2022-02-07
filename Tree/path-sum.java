    // preorder - iterative
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null) {
            return false;
        }
        
        // one stack to keep track of nodes
        Stack<TreeNode> nodes = new Stack();
        // one stack to keep (sum -  sum of nodes val so far) for each node
        Stack<Integer> sums = new Stack();
        
        nodes.push(root);
        sums.push(sum - root.val);
        
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            int curSum = sums.pop();
            
            // if reached a leaf that sum of nodes to get to it is equal sum
            if (curNode.left == null && curNode.right == null && curSum == 0) {
                return true;
            }
            
            if (curNode.right != null) {
                nodes.push(curNode.right);
                sums.push(curSum - curNode.right.val);
            }
            
              if (curNode.left != null) {
                nodes.push(curNode.left);
                sums.push(curSum - curNode.left.val);
            }
        }
        
        return false;
    }
    
    // ----------------------------------------------------------------------
    // recursive
    // te idea is to ask node children for the path with remaining of the sum so far
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null) {
            return false;
        }
        
        // if reach a leaf and the amount of sum been already accumulated
        sum -= root.val;
        if (root.left == null && root.right == null && sum  == 0) {
            return true;
        }
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum); 
    }

// ------------------------------------------------------------------
// recursive - easier solution
class Solution {
    public int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        this.targetSum = targetSum;
        return dfs(root, 0);
        
    }
    
    public boolean dfs(TreeNode root, int currentSum) {
        if (root == null) return false;
        
        currentSum += root.val;
        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }
        
        return dfs(root.left, currentSum) || dfs(root.right, currentSum);
        
    }
}