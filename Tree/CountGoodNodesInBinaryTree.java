/**
 * dfs - recursive
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int maxValue) {
        
        // base case
        if (root == null) return 0;
        int result = 0;
        
        // if the current node is a good node
        if (root.val >= maxValue) {
            result += 1;
        }
        maxValue = Math.max(root.val, maxValue);
        
        // check for left and right subtree
        int goodNodeCountInleft = dfs(root.left, maxValue);
        int goodNodeCountInRight = dfs(root.right, maxValue);
        
        return result + goodNodeCountInleft + goodNodeCountInRight;
    }
}

//-------------------------------------------
/**
 * dfs - iterative
 */
class Pair {
    TreeNode node;
    int maxSoFar;
    
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    int result = 0;
        
    public int goodNodes(TreeNode root) {
        
        if (root == null) return 0;
        LinkedList<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, root.val));
        
        while (!stack.isEmpty()) {
            
            Pair cur = stack.pop();
            if (cur.node.val >= cur.maxSoFar) {
                result++;
            }
            
            if (cur.node.left != null) {
                stack.push(new Pair(cur.node.left, Math.max(cur.node.val, cur.maxSoFar)));
            }
            
            if (cur.node.right != null) {
                stack.push(new Pair(cur.node.right, Math.max(cur.node.val, cur.maxSoFar)));
            }
        
        }
        
       return result;
    }

}
// -----------------------------------------------------
/**
 * bfs
 */

class Pair {
    public TreeNode node;
    public int maxSoFar;
    
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, root.val));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.maxSoFar <= curr.node.val) {
                numGoodNodes++;
            }
            
            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
            
            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
            }  
        }

        return numGoodNodes;
    }
}