// bottom-up
// time snd space complexity: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 0;
        
        for (int i = 2; i < n + 1; i++) {
            // recurrence relation
            table[i] = Math.min(table[i - 1] + cost[i - 1], table[i - 2] + cost[i - 2]);
        }
        
        return table[n];   
    }
}

// -----------------------------------------------------------
// Bottom-Up, Constant Space
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }
        
        return downOne;
    }
}

// -----------------------------------------------------------
// top-down
// time snd space complexity: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return memoization(cost, cost.length, new HashMap<Integer, Integer>());
    }
    
    public int memoization(int[] cost, int index, Map<Integer, Integer> memo) {
        
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        if (index == 0 || index == 1) return 0;
        
        int result = Math.min(memoization(cost, index - 1, memo) + cost[index - 1], memoization(cost, index - 2, memo) + cost[index - 2]);
        memo.put(index, result);
        return result;   
    }
}