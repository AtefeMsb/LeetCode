package DynamicProgrammingFCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @param targetSum(int): target value - numbers(List): list of non-negative numbers
 * @return an array containing any combination of elements that add up to
 *         exactly target sum - NULL if there is no combination
 */

public class HowSum {

      /**
      *  HOW SUM NAIVE IMPLEMENATION

      * m = target sum
      * n = array length (numbers.length)
      * Time Complexity: O(n ^ m * m)   "* m" is for copying the array
      * Space Complexity: O(m)
      */
    public static List sumNaive(int targetSum, List<Integer> numbers) {

        if (targetSum == 0) { return new ArrayList<>(); }
        if (targetSum < 0) { return null; }

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> result = sumNaive(remainder, numbers);

            if (result != null) {
                result.add(0, num);
                return result;
            }
        }

        return null;
    }


        /**
         * HOW SUM DYNAMIC IMPLEMENATION
        * USING MEMOIZATION

        * m = target sum
        * n = array length
        * Time Complexity: O(m * n * m)
        * Space Complexity: O(m * m)  m: numbers of keys for memo object - m: length of array of each keys
        */

    public static List sum(int targetSum, List<Integer> numbers) {
        return sumMemoization(targetSum, numbers, new HashMap<>());
    }

    private static List sumMemoization(int targetSum, List<Integer> numbers, HashMap<Integer, List> memo) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) { return new ArrayList<>(); }
        if (targetSum < 0) { return null; }

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> result = sumMemoization(remainder, numbers, memo);

            if (result != null) {
                result.add(0, num);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {

        System.out.println(sum(7, Arrays.asList(2, 3)));
        System.out.println(sum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(sum(7, Arrays.asList(2, 4)));
        System.out.println(sum(8, Arrays.asList(2, 3, 5)));
        System.out.println(sum(300, Arrays.asList(7, 14)));
        
    }
}
