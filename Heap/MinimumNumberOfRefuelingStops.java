class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        // if startFuel is enough, no fueling stop is needed
        if (startFuel >= target) return 0;
        
        // max heap oto save past fuels
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        
        // while we have not reach the target
        while (maxDistance < target) {
            // if index less than n and position of this index reachable
            while (i < n && stations[i][0] <= maxDistance) {
                // put this station fuel as a past fuel
                queue.offer(stations[i][1]);
                i++;
            }
            
            // don't have enough fuel to go further
            
            if (queue.isEmpty()) return -1;
            
            // we pick the largest from past fuels
            maxDistance += queue.poll();
            stops++;
        }
        
        return stops;
    }
}