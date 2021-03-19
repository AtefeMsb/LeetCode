package Greedy;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        // preprocessing step to make sure there is a valid route to begin with
        int totalDif = 0;
        for (int i = 0; i < gas.length; i++) {
            totalDif += gas[i] - cost[i];
        }
        
        // if the sum of diffrences of gas and cost, the problem doesn't have solution
        if (totalDif < 0) {
            return -1;
        } else {
            // start from starting point of zero with an empty tank
            int starting = 0;
            int tank = 0;
            
            // try all the starting points to see which one works
            for (int i = 0; i < gas.length; i++) {
                tank += gas[i] - cost[i];
                // at any point if the tank is negative, we change the starting point to
                // one step after the step that tank was negative and reset the tank to zero
                if (tank < 0) {
                    starting = i + 1;
                    tank = 0;
                }
            }
            
            return starting;
        }
    }
}