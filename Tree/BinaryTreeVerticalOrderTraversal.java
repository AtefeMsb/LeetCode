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