package AuguestChallenge2020;


class Triplet<F, S, T> {
    
    public final F first;
    public final S second;
    public final T third;

    public Triplet(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
}

/*

the idea to solve the problem would be as intuitive as building a list where each element in the list
corresponds to the 3-dimensional coordinates of each node in the tree, and then sorting the list based 
on the coordinates.
*/

class VerticalOrderTraversalOfABinaryTree {
    
    List<Triplet<Integer, Integer, Integer>> nodeList = new ArrayList<>();

    /*
    
    we traverse the input tree either by BFS or DFS, in order to generate a list
    that contains the 3-dimensional coordinates (i.e. <column, row, value>) of each node.
    
    Note that, we assign a higher row index value to a node's child node. This convention is
    at odds with the denotation given in the problem description. This is done intentionally,
    in order to keep the ordering of all coordinates consistent, i.e. a lower value in any
    specific coordinate represents a higher order. As a result, a sorting operation in
    ascending order would work for each coordinate consistently.

    */
    private void BFS(TreeNode root) {
        Queue<Triplet<TreeNode, Integer, Integer>> queue = new ArrayDeque();
        int row = 0, column = 0;
        queue.offer(new Triplet(root, row, column));

        while (!queue.isEmpty()) {
            Triplet<TreeNode, Integer, Integer> triplet = queue.poll();
            root = triplet.first;
            row = triplet.second;
            column = triplet.third;

            if (root != null) {
                this.nodeList.add(new Triplet(column, row, root.val));
                queue.offer(new Triplet(root.left, row + 1, column - 1));
                queue.offer(new Triplet(root.right, row + 1, column + 1));
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        // step 1). BFS traversal
        BFS(root);

        // step 2). sort the global list by <column, row, value>
        Collections.sort(this.nodeList, new Comparator<Triplet<Integer, Integer, Integer>>() {
            
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1, Triplet<Integer, Integer, Integer> t2) {
                
                // first: column
                // second: row
                // thirs: value
                if (t1.first.equals(t2.first)) {
                    
                    if (t1.second.equals(t2.second)) {
                        return t1.third - t2.third;
                    } else {
                        return t1.second - t2.second;
                    }
                    
                } else {
                    return t1.first - t2.first;
                }
            }
        });

        // step 3). extract the values, partitioned by the column index.
        List<Integer> currColumn = new ArrayList();
        Integer currColumnIndex = this.nodeList.get(0).first;

        for (Triplet<Integer, Integer, Integer> triplet : this.nodeList) {
            
            Integer column = triplet.first;
            Integer value = triplet.third;
            
            if (column == currColumnIndex) {
                currColumn.add(value);
            } else {
                output.add(currColumn);
                currColumnIndex = column;
                currColumn = new ArrayList();
                currColumn.add(value);
            }
        }
        output.add(currColumn);

        return output;
    }
}