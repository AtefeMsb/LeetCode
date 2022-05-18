// https://leetcode.com/problems/bus-routes/discuss/122712/Simple-Java-Solution-using-BFS

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) return 0;
        int res = 0;
        
        // busstop: key --- bus number: value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // bus number i
        for (int i = 0; i < routes.length; i++) {
            // all the stops of bus number i
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new ArrayList<>());
                }
                
                map.get(stop).add(i);
            }
            
        }
        
        // bfs
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // add the first bus stop to the queue
        queue.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            
            for (int i = 0; i < size; i++) {
                
                // the cur stop
                int cur = queue.remove();
                // what buses pass through this cur stop 
                List<Integer> buses = map.get(cur);
                
                for (int bus : buses) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    // add all the stops of the bus to the queue
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == target) {
                            return res;
                        }
                        queue.add(routes[bus][j]);  
                   }
                }
              
            }
           
        }
        
        return -1; 
    }
}