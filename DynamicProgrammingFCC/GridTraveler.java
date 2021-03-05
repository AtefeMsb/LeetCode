package DynamicProgrammingFCC;

import java.util.HashMap;
import java.util.Map;

/**
 * travel in a grid of m * n from top-left to bottom-right
 * only move "right" and "down"
 * @return how many ways can travel?
 * @param m(int): number of rows - n(int): number of columns
 */

public class GridTraveler {

/**
 * FIBONACCI DYNAMIC IMPLEMENTATION
 * USING MEMOIZATION
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */ 
private static Long travelingNaive(int m, int n) {
    return travelingMemoiztion(m, n, new HashMap<>());
}
private static Long travelingMemoiztion(int m, int n, HashMap<String, Long> memo) {

    String key = m + "," + n;
    if (memo.containsKey(key)) {
        return memo.get(key);
    }

    // base case -  1 * 1 grid
    if (m == 1 && n == 1) return (long)1;
    // invalid case - Empty grid
    if (m == 0 || n == 0) return (long)0;

    // one child goes one down or one child goes one right
    memo.put(key, travelingMemoiztion(m - 1, n, memo) + travelingMemoiztion(m, n - 1, memo));
    return memo.get(key);
}

// ===============================================================================================
/** 
 * FIBONACCI DYNAMIC IMPLEMENTATION
 * USING TABULATION
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public static Long travelingTabulation(int m, int n) {

    long[][] table = new long[m + 1][n + 1];
    for (int i = 0; i <= m ; i++) {
        for (int j = 0; j <= n; j++) {
            table[i][j] = 0;
        }
    }

    // 1 * 1 grid has only one way of traveling
    table[1][1] = 1;

    // each item gets added to the square on the right and the one on its bottom
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            long current = table[i][j];
            // down neighbor
            if (i + 1 <= m) table[i + 1][j] += current;
            // right neighbor
            if (j + 1 <= n) table [i][j + 1] += current;
        }
    }

    return table[m][n];

}

// ===============================================================================================

    public static void main(String[] args) {
        System.out.println(travelingTabulation(1, 1));
        System.out.println(travelingTabulation(2, 3));
        System.out.println(travelingTabulation(3, 2));
        System.out.println(travelingTabulation(3, 3));
        System.out.println(travelingTabulation(18, 18));
    }
    
}
