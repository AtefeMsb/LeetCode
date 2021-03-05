package DynamicProgrammingFCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * @param targetsum(int): target value - numbers(List): list of non-negative numbers
 * @return an array containing any the shortest combination of elements that add up to exactly target sumNaive - NULL if there is no combination
 */

public class BestSum {

      /**
      *  BEST SUM NAIVE IMPLEMENATION

      * m = target sum
      * n = array length (numbers.length)
      * Time Complexity: O(n ^ m * m)   "* m" is for copying the array --- O(BRANCH_FACTOR ^ TREE_DEPTH)
      * Space Complexity: O(m * m) "* m" need to store array as recurse, its for shortestCombination variable
      */
    public static List sumNaive(int targetSum, List<Integer> numbers) {

        if (targetSum == 0) { return new ArrayList<>(); }
        if (targetSum < 0) { return null; }

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = sumNaive(remainder, numbers);

            // add the current number to the path
            if (remainderCombination != null) {
                List<Integer> combination = new ArrayList<>();
                combination.addAll(remainderCombination);   // copy of array O(m)
                combination.add(num);

                // if its the first path or size of the current path is less than global shortest
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }

        }

        return shortestCombination;
    }

    // ===============================================================================================
    /**
    * BEST SUM DYNAMIC IMPLEMENATION
    * USING MEMOIZATION

    * m = target sum
    * n = array length
    * Time Complexity: O(m * n * m)
    * Space Complexity: O(m * m)  m: numbers of keys for memo object - m: length of value / array of each keys
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

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = sumMemoization(remainder, numbers, memo);

            if (remainderCombination != null) {
                List<Integer> combination = new ArrayList<>();
                combination.addAll(remainderCombination);
                combination.add(num);
                
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        memo.put(targetSum, shortestCombination);
        return shortestCombination;


    }
    // ===============================================================================================
    /**
    * BEST SUM DYNAMIC IMPLEMENATION
    * USING TABULATION

    * m = target sum
    * n = array length
    * Time Complexity: O(m * n * m)
    * Space Complexity: O(m * m) 
    */
    public static List sumTabulation(int targetSum, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            table.add(null);
        }

        // base case - for targetSum 0 there is an empty list
        table.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++) {
            List<Integer> current = table.get(i);

            if (current != null) {
                for (int num : numbers) {

                    int index = i + num;
                    if (index <= targetSum) {

                        List<Integer> updatedCurrent = new ArrayList<>(current);
                        updatedCurrent.add(0, num);

                        // if the num space away is null OR it is longer than new found, replace it with the new combination
                        if (table.get(index) == null ||  updatedCurrent.size() < table.get(index).size()) {
                            table.set(index, updatedCurrent);
                        }
                    }
                }
            }
        }

        return table.get(targetSum);

    }
    // ===============================================================================================
    public static void main(String[] args) {

        System.out.println(sumTabulation(2, Arrays.asList(1,2)));
        System.out.println(sumTabulation(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(sumTabulation(8, Arrays.asList(2, 3, 5)));
        System.out.println(sumTabulation(8, Arrays.asList(1, 4, 5)));
        System.out.println(sumTabulation(100, Arrays.asList(1, 2, 5, 25)));
        
    }
}
