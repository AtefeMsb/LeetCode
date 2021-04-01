package Graph;

/**
 * DFS
 * time complexity: O(∣E∣+∣V∣) where |V| is the number of courses, and |E| is the number of dependencies.
 * space complexity: O(∣E∣+∣V∣)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // create an adjacency list (build the graph)
        // key: course num  , value: prerequsites num
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        // map each course to an empty list
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        
        // add the prerequesites to each course list
        for (int[] pre : prerequisites) {
                adjacencyList.get(pre[0]).add(pre[1]);
        }
        
        // print the adjacency list
        System.out.println(Arrays.toString(adjacencyList.entrySet().toArray()));

        // all the courses along the dfs path 
        Set<Integer> visited = new HashSet<>();
        
        // run the dfs for each of courses
        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs, adjacencyList, visited)) {
               return false; 
            } 
        }
        
        return true;
    }
    
    // dfs traversal
    private boolean dfs(int crs, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited) {
        
        // base cases
        // if visited course before, so detected a loop
        if (visited.contains(crs)) return false;  
        // prerequits of this list is an empty list, so it can be completed
        if (adjacencyList.get(crs).isEmpty()) return true;
        
        visited.add(crs);
        
        // run dfs recursively for its prerequist
        for (int pre : adjacencyList.get(crs)) {
            if (!dfs(pre, adjacencyList, visited)) {
                return false;
            }
        }
        
        // remove the visited course from visited set
        visited.remove(crs);
        
        // since we know this crs can be visited, it has no prerequisit, by empty list
        adjacencyList.put(crs, new ArrayList<>());
        
        return true;

    }
}