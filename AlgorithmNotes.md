### 1. Find Cycle In A Directed Graph:
    1. use a states int array that cell means:
        - 0 means UNVISITED
        - 1 means VISITING
        - 2 means VISITED
    2. start from each of vertices and if its is not visited (2), run isCyclicUtil function for it.

    ```java
    // FINDING OUT IF GRAPH HAS CYCLE
    private boolean isCyclic(Map<Integer, List<Integer>> adjacencyList, int numCourses) {
        // state of each course vertices
        // 0 means UNVISITED
        // 1 means VISITING
        // 2 means VISITED
        int[] states = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                if (isCyclicUtil(adjacencyList, states, i)) return true;
            }
        } 
        return false;  
    }

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
    ```

### 2. Topological Sort
- only exists in 'directed acyclic graphps'.
- there might be more than 1 topological ordering for a graph.
- needs 2 ds: stack and set/boolean array
- related questions:
    1. Course Schedule II
    2. Alien Dictionary

### Find Cycle In A UnDirected Graph:

