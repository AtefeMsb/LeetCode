class Fibonacci {

    /////////////////////////////////////////////////////////////////
    // iterative
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int fib(int N) {
        
        if (N <= 1) {
            return N;
        }
        
        // some prev1 and prev2 to get the next number
        int prev1 = 0;
        int prev2 = 1;
        
        // start the index from 1 because prev2 the result will start at index 1
        int i = 1;
        
        while (i < N) {
        
            int temp = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
            
            i++;
           
        }
        
        return prev2;
    }

    /////////////////////////////////////////////////////////////////

    // Bottom-Up Approach using Memoization
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int fib(int N) {
        
        int[] cache = new int[N + 1];
    
        if (N <= 1) {
            return N;
        }
        
        cache[0] = 0;
        cache[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        
        return cache[N];
    }

    ///////////////////////////////////////////////////////////////////

    // Top-Down Approach using Memoization
    // Time complexity: O(n)
    // Space complexity: O(n)
    private Integer[] cache = new Integer[31];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memoize(N-1) + memoize(N-2);
      return memoize(N);
    }

}
