package DynamicProgrammingFCC;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) - height of the tree
 */
public class Fib {


    /**
     * FIBONACCI DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public static long fibonacci(int n) {
        return fibonacciMemoization(n, new HashMap<>());
    }

    private static long fibonacciMemoization(int n, HashMap<Integer,Long> memo) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n < 2) { 
            return (long)n;
        }

        memo.put(n, fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo));
        return memo.get(n);
    }
    // ===============================================================================================
    /** 
     * FIBONACCI DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */

     public static long fibonacciTabulation(int n) {

        long[] table = new long[n + 1]; 
        for (int i = 0; i <= n; i++) {
            table[i] = 0;
        }
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
     }



    // ===============================================================================================
    public static void main(String[] args) {
        System.out.println(fibonacciTabulation(6));
        System.out.println(fibonacciTabulation(7));
        System.out.println(fibonacciTabulation(8));
        System.out.println(fibonacciTabulation(50));
    }
    }
