// source: https://www.youtube.com/watch?v=nHR8ytpzz7c&t=877s
// Time and space complexity: O(N)
class Pair {
    int first;
    int second;
    
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}
class Solution {
    public int rob(TreeNode root) {
        
        Pair result = dfs(root);
        return Math.max(result.first, result.second); 
        
    }
    
    // Pair (WITH root result, WITHOUT root result)
    // postorder traversal
    public Pair dfs(TreeNode root) {
        
        // if root is null, maximum value is zero
        if (root == null) {
            return new Pair(0, 0);
        }
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        // if with root, the child must be without root + root value
        int withRoot = root.val + left.second + right.second;
        // if without root, no limit on childs
        int withoutRoot = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        
        return new Pair(withRoot, withoutRoot);

    }
}

// ------------------------------------------------
// dfs with added memoization
class Pair {
    int first;
    int second;
    
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}
class Solution {
    public int rob(TreeNode root) {
        
        Pair result = dfs(root, new HashMap<TreeNode, Pair>());
        return Math.max(result.first, result.second); 
        
    }
    
    // Pair (WITH root result, WITHOUT root result)
    // postorder traversal
    public Pair dfs(TreeNode root, Map<TreeNode, Pair> memo) {
        
        // check the memo table
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        
        // if root is null, maximum value is zero
        if (root == null) {
            return new Pair(0, 0);
        }
        
        Pair left = dfs(root.left, memo);
        Pair right = dfs(root.right, memo);
        
        // if with root, the child must be without root + root value
        int withRoot = root.val + left.second + right.second;
        // if without root, no limit on childs
        int withoutRoot = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        
        Pair temp = new Pair(withRoot, withoutRoot);
        memo.put(root, temp);
        
        return temp;

    }
}