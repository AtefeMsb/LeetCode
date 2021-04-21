class Solution {
    
    Map<String, List<String>> adjacencyList = new HashMap<>();
    Map<String, boolean[]> visited = new HashMap<>();
    int flightCount = 0;
    List<String> result = null;

public List<String> findItinerary(List<List<String>> tickets) {

    // 1. create the adjacency list
    for (List<String> ticket : tickets) {
        String src = ticket.get(0);
        String des = ticket.get(1);
        if (!adjacencyList.containsKey(src)) {
            List<String> destinations = new ArrayList<>();
            destinations.add(des);
            adjacencyList.put(src, destinations);
        } else {
            adjacencyList.get(src).add(des);
        }
    }
    
    // 2. sort the list lexically to pick the smallest lexical order
    // also initialize and fill out the visited hashmap with false
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
        Collections.sort(entry.getValue());
        visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
    }
    
    // 3. run dfs/backtrack to find the valid path starting from "JFK"
    flightCount = tickets.size();
    LinkedList<String> route = new LinkedList<>();
    route.add("JFK");
    backtracking("JFK", route);
    return result;
}

// this function is DFS but applies some constraints 
private boolean backtracking(String origin, LinkedList<String> route) {
    
    // base case - check if already cretaed a valid itenary
    if (route.size() == flightCount + 1) {
        this.result = (List<String>) route.clone();
        return true;
    }
    
    // if there is no entry from this origin
    if (!this.adjacencyList.containsKey(origin)) {
        return false;
    }
    
    // get the visited arraybinfro for this origin
    int i = 0;
    boolean[] seen = this.visited.get(origin);
    
    // enumerate the next destinations for this origin in order
    for (String dest : this.adjacencyList.get(origin)) {
        if (!seen[i]) { // if hasn not been seen
            seen[i] = true;
            route.add(dest);
            boolean ret = backtracking(dest, route);
            
            // remove our last choice and clean up
            route.pollLast();
            seen[i] = false;
            
            if (ret) return true;
        }
        i++;
    }
    
    return false;  
}

}