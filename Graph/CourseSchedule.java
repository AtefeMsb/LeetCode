package Graph;

/**
 * DFS
 * time complexity: O(∣E∣+∣V∣) where |V| is the number of courses, and |E| is the number of dependencies.
 * space complexity: O(∣E∣+∣V∣)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // create an adjacency list (build the graph)
        // KEY: course number  , VALUE: the course that depends on it
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
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
        
        // print the adjacency list
        System.out.println(Arrays.toString(adjacencyList.entrySet().toArray()));

        // state of each course vertices
        // 0 means UNVISITED
        // 1 means VISITING
        // 2 means VISITED
        int[] states = new int[numCourses];

        // run the dfs for each of courses
        for (int crs = 0; crs < numCourses; crs++) {
            if (states[crs] == 0) {
                if (isCyclic(adjacencyList, states, crs)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isCyclic(Map<Integer, List<Integer>> adjacencyList, int[] states, int crs) {
        
        // processing a node in "visiting" state means there is a cycle
        if (states[crs] == 1) return true;
        
        // make the node state "visiting"
        states[crs] = 1;
        
        // run dfs recursively for each of its destination
        for (int dest : adjacencyList.get(crs)) {
            if (states[dest] != 2) {
                if (isCyclic(adjacencyList, states, dest)) {
                 return true;
                }
            }
        }
        
        // make the node state "visited"
        states[crs] = 2;
        
        return false;
    } 
}