package DynamicProgrammingFCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanSum {
    
    /**
     * questions wether is possible to generate the target from the list of numbers
     * it is okay to use any of the numbers multiple times
     * @param targetSum(int): target value - numbers(List): list of non-negative numbers 
     * @return boolean: wether or not is possible to generate targetSum from the list
     */

     /**
      *  CANSUM NAIVE IMPLEMENATION
      * m = target sum
      * n = array length
      * Time Complexity for memoizaion: O(n ^ m)
      * Space Complexity for memoizaion: O(m)
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


      /**
      * CANSUM NAIVE DYNAMIC IMPLEMENATION
      * USING MEMOIZATION
      * m = target sum
      * n = array length
      * Time Complexity for memoizaion: O(m * n)
      * Space Complexity for memoizaion: O(m)
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
            if (sum(remainder, numbers) == true) {
                memo.put(targetSum, true);
                return true;
            }             
        }

        memo.put(targetSum, false);
        return false; 
    }
    public static void main(String[] args) {
        System.out.println(sum(7, Arrays.asList(2, 3)));
        System.out.println(sum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(sum(7, Arrays.asList(2, 4)));
        System.out.println(sum(8, Arrays.asList(2, 3, 5)));
        System.out.println(sum(300, Arrays.asList(7, 14)));
    }
}
