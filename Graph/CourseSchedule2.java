package Graph;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // create an adjacency list (build the graph)
        // KEY: course number  , VALUE: the course that depends on it
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] topologicalOrder = new int[numCourses];
        
        // map each course to an empty list
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        
        // add the prerequesites to each course list
        // destination: pre[0]
        // source : pre[1]
        for (int[] pre : prerequisites) {
                adjacencyList.get(pre[1]).add(pre[0]);
        }
        
        // CASE 1: if there is a cycle in the graph, return an empty list
        if (isCyclic(adjacencyList, numCourses)) {
            System.out.println("this graph has cycle so it is impossible to find its topological order");
            return new int[0];
        }
      
        // CASE 2: if there is no cycle so topological order can be found
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);

        // apply DFS to all the course to find the topological order
        for (int crs = 0; crs < numCourses; crs++) {
            if (visited[crs] == false) {
                dfs(adjacencyList, visited, stack, crs);   
            }
        }
        
        // stack has the topological ordering in reverse, so when pop will be the right order
        int i = 0;
        while (!stack.isEmpty()) {
            topologicalOrder[i++] = stack.pop();
        }
        
        return topologicalOrder;
    }
    
    // TOPOLOGICAL SORT ALGORITHM - using DFS and Stack
    private void dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, LinkedList<Integer> stack, int crs) {
        
        visited[crs] = true;
        for (int dest : adjacencyList.get(crs)) {
            if (visited[dest] != true) {
                dfs(adjacencyList, visited, stack, dest);
            }
        }
        stack.push(crs);
    
    }
    
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

}