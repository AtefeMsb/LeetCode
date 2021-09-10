package Graph;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
// Breadth First Search
// Time Complexity : O(N + M), where N is a number of nodes (vertices) and M is a number of edges.
// Space Complexity : O(N).
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}
// ---------------------------------------
/**
 * DFS 
 */
class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
        
    }
    
    public Node dfs(Node node, Map<Node, Node> oldToNew) {
        
        // base case - if already been visited and cloned only return it
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        
        // clone the node
        Node clone = new Node(node.val, new ArrayList<>());
        oldToNew.put(node, clone);
        
        // clone all its neighbors
        for (Node neigh : node.neighbors) {
            clone.neighbors.add(dfs(neigh, oldToNew));
        }
        
        return clone;
    }
}