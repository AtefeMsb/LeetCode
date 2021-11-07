/**
 * dynamic programming
 * time: O(n ^ 2)
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        // dp[i], the farthest location we can get to using i refueling stops.
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                
                // if we can reach this station with t stop, how fard we can go if we refule here
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}
// ------------------------------------------------
/**
 * max heap
 * strategy: we want to drive as long as possible before running out of gas with the fuel we have
 * if we did not have enough fuel to reach an station, we will pick the biggest fuel we have seen so far
 */

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if (startFuel >= target) return 0;

        // max heap : keep all the seen fueling amount on the way so far
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int maxDistance = startFuel;
        int n = stations.length;
        int i = 0;
        int stops = 0;
        
        // while we have not collect enough gas to get to the target
        while (maxDistance < target) {
            
            // if there are still stations left and the current station is reachable
            while (i < n && stations[i][0] <= maxDistance) {
                pq.add(stations[i][1]);
                i++;
            }
            
            if (pq.isEmpty()) return -1;
            
            // if the current station is not reachable, we need to add the biggest fuel source from before
            maxDistance += pq.remove();
            stops++;   
        }
        
        return stops;
    }
}