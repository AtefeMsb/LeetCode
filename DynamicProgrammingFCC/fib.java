package DynamicProgrammingFCC;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Fib {

    // memoization: a hash map with key (Integer) and value (Long)
    static Map<Integer, Long> memo = new HashMap<>();

    private static Long fibonacci(int n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n < 2) { 
            return (long)n;
        }

        memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return memo.get(n);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(50));
    }
    }
