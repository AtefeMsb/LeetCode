// Iterative
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> prelist = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();

    if (root != null) {
        stack.push(root);
    }

    TreeNode cur;
    while (!stack.isEmpty()) {
        cur = stack.pop();
        prelist.add(cur.val);
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
    }
    return prelist;
}
    
// recursive
private void preorderTraversal(TreeNode root, List result) {
    if (root == null) {
        return;
    }
    result.add(root.val);
    preorderTraversal(root.left, result);
    preorderTraversal(root.right, result);

}
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preorderTraversal(root, result);
    return result;
}
