package DynamicProgrammingFCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

    /**
     * questions whether is possible to generate the target from the list of numbers
     * it is okay to use any of the numbers multiple times
     * @param targetSum(int): target value - numbers(List): list of non-negative numbers 
     * @return boolean: wether or not is possible to generate targetSum from the list
     */

public class CanSum {
     /**
      *  CAN SUM NAIVE IMPLEMENATION

      * m = target sum
      * n = array length
      * Time Complexity: O(n ^ m)
      * Space Complexity: O(m)
      */
    public static boolean sumNaive(int targetSum, List<Integer> numbers) {
        // base case
        if (targetSum == 0) { return true; }
        // stop the recursion if hit a negative number - because here is no way to get to targetSum from that
        if (targetSum < 0) { return false; }

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (sumNaive(remainder, numbers)) {
                return true;
            }
        }

        // after exhausting all the possibility, we can say it is false
        return false; 

    }
    // ===============================================================================================

      /**
      * CAN SUM DYNAMIC IMPLEMENATION
      * USING MEMOIZATION

      * m = target sum
      * n = array length
      * Time Complexity: O(m * n)
      * Space Complexity: O(m)
      */

    public static boolean sum(int targetSum, List<Integer> numbers) {
        return sumMemoization(targetSum, numbers, new HashMap<>());
    }

    private static boolean sumMemoization(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        // search in the memo, look for the subtree
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        // base case
        if (targetSum == 0) { return true; }

        // stop the recursion if hit a negative number - because here is no way to get to targetSum from that
        if (targetSum < 0) { return false; }

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (sumMemoization(remainder, numbers, memo) == true) {
                memo.put(targetSum, true);
                return true;
            }             
        }

        memo.put(targetSum, false);
        return false; 
    }

    // ===============================================================================================
      /**
      * CAN SUM DYNAMIC IMPLEMENATION
      * USING TABULATUION

      * m = target sum
      * n = array length
      * Time Complexity: O(m * n)
      * Space Complexity: O(m)
      */
    public static boolean sumTabulation(int targetSum, List<Integer> numbers) {

        boolean[] table = new boolean[targetSum + 1];
        // set all the elements of table to false
        for (int i = 0; i < table.length; i++) {
            table[i] = false;
        }

        // base case - targetSum of zero is always true, it always possible to make
        table[0] = true;

        // for each item in table
        for (int i = 0; i < table.length; i++) {
            for (int num : numbers) {
                // if item in table is true and] num spaces ahead from the table[i] is a valid space
                if (i + num <= targetSum && table[i] == true) {
                    table[i + num] = true;
                }

            }
        }

        return table[targetSum];
    }

    // ===============================================================================================
    public static void main(String[] args) {
        System.out.println(sumTabulation(7, Arrays.asList(2, 3)));
        System.out.println(sumTabulation(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(sumTabulation(7, Arrays.asList(2, 4)));
        System.out.println(sumTabulation(8, Arrays.asList(2, 3, 5)));
        System.out.println(sumTabulation(300, Arrays.asList(7, 14)));
    }
}
