   // recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        /*
        base cases:
        When we have an answer.
            1.) If the node we are holding is null then we can't search...just return null
            2.) If we find either value return ourselves to the caller
        */
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        /*
        'root' doesn't satisfy any of our base cases.
        Search left and then search right.
        */
        TreeNode leftSearchResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearchResult = lowestCommonAncestor(root.right, p, q);

        /*
        If nothing turned up on the left, return whatever we got
        back on the right.
        */
        if (leftSearchResult == null) return rightSearchResult;

        /*
        If nothing turned up on the right, return whatever we got
        back on the left.
        */
        if (rightSearchResult == null) return leftSearchResult;

        /*
        If we reach here that means we got something back on the left AND
        right...that means this node is the LCA...because our recursion returns
        from bottom to up...so we return what we hold...'root'
        */
        return root;
    }
//--------------------------------------------------------------------------------------------------
      /*
      Algorithm

      1- Start from the root node and traverse the tree.
      2- Until we find p and q both, keep storing the parent pointers in a dictionary.
      3- Once we have found both p and q, we get all the ancestors for p using the parent
      dictionary and add to a set called ancestors.
      4- Similarly, we traverse through ancestors for node q. If the ancestor is present in
      the ancestors set for p, this means this is the first ancestor common between p and q (while traversing upwards)
      and hence this is the LCA node.
      */

    // iterative - saving parents
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // save each node and its parent
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        
        // queue for bfs
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) { return null;}
        queue.offer(root);
        parents.put(root, null);
        
        // stop when both p and q were found (EARLY STOPPING)
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            
            TreeNode cur = queue.poll();
        
            if (cur.left != null) {
                queue.offer(cur.left);
                parents.put(cur.left, cur);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                parents.put(cur.right, cur);
            }

        }
        
        // Ancestors set() for node p.
        Set<TreeNode> pAncestors = new HashSet<>();
        
        // add all ancestors of p to a set
        while (p != null) {
            pAncestors.add(p);
            p = parents.get(p);
        }
        
        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!pAncestors.contains(q)) {
            q = parents.get(q);
        }
        
        return q; 
    }
