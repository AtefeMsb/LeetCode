package DfsBfs;

/* treat the tree as an undirected graph, apply bfs starting from target to find K level close to the target */

class Solution {
    
    // key: node    value: parent node
    Map<TreeNode, TreeNode> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
          
        // find parents of each node and put it in the map
        dfs(root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        // to avoid revisiting the same node
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            
            // if reach to the Kth kevel distance
            // return all the nodes as result
            if (level == K) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            
            // apply bfs for each level
            // bfs includes left, right, and parent node
            int size = queue.size();
        
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null && !seen.contains(node.left)) {
                  seen.add(node.left);
                  queue.offer(node.left);
                }

                if (node.right != null && !seen.contains(node.right)) {
                  seen.add(node.right);
                  queue.offer(node.right);
                }

                TreeNode parent = map.get(node);

                if (parent != null && !seen.contains(parent)) {
                  seen.add(parent);
                  queue.offer(parent);
                }
            }

            level++;
        }

        return new ArrayList<>();
    }
    
    // find parents of each node and sav them in a hash map
    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}