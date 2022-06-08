// BFS
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        // bfs: Pair(node, column number)
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        queue.add(new Pair(root, 0));
        
        // range of columns
        int min = 0;
        int max = 0;
        
        while (!queue.isEmpty()) {
            
            Pair<TreeNode, Integer> p = queue.remove();
            TreeNode node = p.getKey();
            int col = p.getValue();
            
            if (node != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
            
                map.get(col).add(node.val);
                
                min = Math.min(min, col);
                max = Math.max(max, col);
                
                queue.add(new Pair(node.left, col - 1));
                queue.add(new Pair(node.right, col + 1));
            }      
        }
        
        for (int i = min; i < max + 1; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}

// ------------------------------------------------------------
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
class NodeUtil {
    TreeNode node;
    int column;
    
    public NodeUtil(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
    
        LinkedList<NodeUtil> queue = new LinkedList<>();
        queue.add(new NodeUtil(root, 0));
        
        int min = 0;
        int max = 0;
        
        while (!queue.isEmpty()) {
            
            NodeUtil cur = queue.remove();
            TreeNode node = cur.node;
            int column = cur.column;
            
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }
            
            min = Math.min(min, column);
            max = Math.max(max, column);
            
            map.get(column).add(node.val);
            
            if (node.left != null) {
                queue.add(new NodeUtil(node.left, column - 1));
            }
            
             if (node.right != null) {
                queue.add(new NodeUtil(node.right, column + 1));
            }
               
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
        
    }
}