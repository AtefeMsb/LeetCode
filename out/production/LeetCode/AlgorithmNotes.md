### 1. Find Cycle In A Directed Graph
    - DFS and states int array
    - use a states int array that cell means:
        - 0 means UNVISITED
        - 1 means VISITING
        - 2 means VISITED
    - start from each of vertices and if its is not visited (!= 2), run isCyclicUtil function for it.

    // FINDING OUT IF GRAPH HAS CYCLE
    private boolean isCyclic(Map<Integer, List<Integer>> adjacencyList, int numCourses) {
        int[] states = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                if (isCyclicUtil(adjacencyList, states, i)) return true;
            }
        } 
        return false;  
    }

    // -------------------------------------------------------------

    private boolean isCyclicUtil(Map<Integer, List<Integer>> adjacencyList, int[] states, int crs) {

        // processing a node in "visiting" state means there is a cycle
        if (states[crs] == 1) return true;
        // make the node state "visiting"
        states[crs] = 1;

        // run dfs recursively for each of its destination
        for (int dest : adjacencyList.get(crs)) {
            if (states[dest] != 2) {
                if (isCyclicUtil(adjacencyList, states, dest)) return true;
            }
        }

        // make the node state "visited"
        states[crs] = 2;
        return false;
    }
    

### 2. Topological Sort
- only exists in **directed acyclic graphps**.
- there might be more than 1 topological ordering for a graph.
- needs 2 ds: stack and set/boolean array
- related questions:
    1. Course Schedule II
    2. Alien Dictionary

```
  // if there is no cycle so topological order can be found
    int[] topologicalOrder = new int[numCourses];
    LinkedList<Integer> stack = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    // apply DFS to all the course to find the topological order
    for (int i = 0; i < numCourses; i++) {
        if (!visited.contains(i)) {
            dfs(adjacencyList, visited, stack, i);
        }
    }
    
    // stack has the topological ordering in reverse, so when pop will be the right order
    int i = 0;
    while (!stack.isEmpty()) {
        topologicalOrder[i++] = stack.pop();
    }

    // -------------------------------------------------------------

    // TOPOLOGICAL SORT ALGORITHM - using DFS and Stack
    private void dfs(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited, LinkedList<Integer> stack, int crs) {
        
        visited.add(crs);
        for (int neig : adjacencyList.get(crs)) {
            if (!visited.contains(neig)) {
                dfs(adjacencyList, visited, stack, neig);
            }
        }
       
        stack.push(crs);
    }
```

### Find Cycle In A UnDirected Graph:
    - DFS and a set for visited
    - EDGE CASE: pass the previous node to the function, so it does not count as loop mistakenly
    - add both side of an edge to the adjacency list.

    
     private boolean hasCycle(Map<Integer, List<Integer>> list, Set<Integer> visited,  int node, int prev) {
        
        // if the node has already been seen
        if (visited.contains(node)) return true;
        visited.add(node);
        
        for (int neighbor : list.get(node)) {
            // Edge Case: the immidiate node before current node won't be visited, because faulsy detects a loop!
            if (neighbor == prev) continue;
            if (hasCycle(list, visited, neighbor, node)) {
                return true;
            }
        }
        
        return false;
    }

