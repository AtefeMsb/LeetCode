package AuguestChallenge2020;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// BFS - without sorting
// Time Complexity: O(N) where N is the number of nodes in the tree.
// Space Complexity: O(N) where N is the number of nodes in the tree.
/*
The key insight is that we only need to know the range of the column index (i.e. [min_column, max_column]). Then we can simply iterate through this range to generate the outputs without the need for sorting.
*/
class BinaryTreeVerticalOrderTraversal2 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        
    List<List<Integer>> output = new ArrayList();
        
    if (root == null)  return output;
        
        // save the TreeNode and its column number in the queue
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        
        // save TreeNode in the same column (key)
        Map<Integer, ArrayList> columnTable = new HashMap();
        
        int column = 0;
        
        int minColumn = 0, maxColumn = 0;
        
        // add the root of the tree to the queue for BFS
        queue.offer(new Pair(root, column));
    
        
        while (!queue.isEmpty()) {
            
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();
            
            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
                
                // add left and right children to teh queue
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
                
            }
        }
        
        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }
        
        return output;
    }
}