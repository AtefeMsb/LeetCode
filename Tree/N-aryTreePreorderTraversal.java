class Solution {
    public List<Integer> preorder(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        // add to the end of deque
        stack.add(root);
        while (!stack.isEmpty()) {
            // remove from the end of deque
            Node node = stack.pollLast();
            result.add(node.val);
            List<Node> children = node.children;
            Collections.reverse(children);
            for (Node child : children) {
                stack.add(child);
            }
        }
        
        return result; 
    }
}