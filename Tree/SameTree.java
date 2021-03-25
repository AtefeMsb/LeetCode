package Tree;

/**
* recursion
* Time complexity : O(N)
* Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  
    }
}
// ------------------------------------
/**
* recursion
* Time complexity : O(N)
* Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
*/
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
       
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        // used linkedlist instead of ArrayDeque to implement the queue, because need to add NULL values as well
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        
        
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            
            if (first == null && second == null) continue;
            if (first == null || second == null) return false;
            if (first.val != second.val) return false;
            
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);    
        }
        
        return true;
    }
}
