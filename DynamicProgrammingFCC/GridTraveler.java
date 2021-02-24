package DynamicProgrammingFCC;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

/**
 * travel in a grid of m * n from top-left to bottom-right
 * only move "right" and "down"
 * @return how many ways can travel?
 * @param m(int): number of rows - n(int): number of columns
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */

static Map<String, Long> memo = new HashMap<>();

private static Long traveling(int m, int n) {

    String key = m + "," + n;
    if (memo.containsKey(key)) {
        return memo.get(key);
    }

    // base case
    if (m == 1 && n == 1) return (long)1;
    // invalid case
    if (m == 0 || n == 0) return (long)0;

    // traveling one down or traveling one right
    memo.put(key, traveling(m - 1, n) + traveling(m, n - 1));
    return memo.get(key);
}

    public static void main(String[] args) {
        System.out.println(traveling(1, 1));
        System.out.println(traveling(2, 3));
        System.out.println(traveling(3, 2));
        System.out.println(traveling(3, 3));
        System.out.println(traveling(18, 18));
    }
    
}
