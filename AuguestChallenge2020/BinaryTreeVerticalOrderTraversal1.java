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

// BFS
// Time Complexity: O(NlogN) where N is the number of nodes in the tree.
// Space Complexity: O(N) where N is the number of nodes in the tree.
class BinaryTreeVerticalOrderTraversal1 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        
    List<List<Integer>> output = new ArrayList();
        
    if (root == null)  return output;
        
        // save the TreeNode and its column number in the queue
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        
        // save TreeNode in the same column (key)
        Map<Integer, ArrayList> columnTable = new HashMap();
        
        int column = 0;
        
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
                
                // add left and right children to teh queue
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
                
            }
        }
        
        // print the columnList HashMap
        System.out.println("columnTable: " + columnTable);
        
        // sort the columnList HashMap by its keys
        List<Integer> keys = new ArrayList<Integer>(columnTable.keySet());
        System.out.println("unsorted keys: "+ keys);
        
        Collections.sort(keys);
        System.out.println("sorted keys: "+ keys);

        for(int k : keys) {
            output.add(columnTable.get(k));
    }
        
        return output;
    }
}
