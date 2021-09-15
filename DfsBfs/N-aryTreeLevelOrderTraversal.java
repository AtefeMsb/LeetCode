class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i  = 0; i < size; i++) {
                Node cur = queue.remove();
                level.add(cur.val);

                List<Node> children = cur.children;
                for (Node child : children) {
                    queue.add(child);
                }
            }
            
            result.add(level);   
        }
        
        return result;
    }
}