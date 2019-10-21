// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
        
//         for (int i = 2; i < cost.length; i++) {
//             cost[i] += Math.min(cost[i - 1], cost[i - 2]);
//         }
        
//         return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int step1 = 0;
        int step2 = 0;
        
        for (int i = cost.length - 1; i >= 0; i--) {
            int current = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = current;
            
            System.out.println("current: " + current);
            System.out.println("step1: " + step1);
            System.out.println("step2: " + step2);
        }
        
        return Math.min(step1, step2);
    }
}
