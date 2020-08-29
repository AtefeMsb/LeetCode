package recursion;

public class ClimbingStairs {
    
    ////////////////////////////////////////////////////////////
    // iterative
    // time: O(n)
    // space: O(1)
    int climbStairs(int n) {
        
        if (n == 1) {
            return 1;
        }
        
        // there are 1 way to travel to step 1
        int one = 1;
        // there are 2 ways to travel to step 2
        int two = 2;
        // start from step 3
        int i = 3;
        
        while (i <= n) {
            
            int temp = one + two;
            one = two;
            two = temp;
            
            i++;
        }
        
        return two;

    }

    /////////////////////////////////////////////////////////

    // Bottom-Up Approach using Memoization - Dynamic Programming
    // Time complexity: O(n)
    // Space complexity: O(n)

    public int climbStairs(int n) {
        
        if (n == 1) {
             return 1;
        }
        
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        
        return cache[n];
        
    }

}