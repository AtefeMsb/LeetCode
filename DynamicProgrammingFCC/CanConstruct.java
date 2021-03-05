package DynamicProgrammingFCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * DECISION PROBLEM: Verify if is possible to target word be constructed by concatenating elements of the string array.
 * @param target
 * @param wordBank
 */

public class CanConstruct {

    /**
     * CAN CONSTRUCT NAIVE IMPLEMENATION
     * 
     * m = target.length
     * n = wordBank.length
     * time complexity: O(n ^ m * m) second m: is because of finding substring
     * space complexity: O(m * m) first m: depth of the tree - second m: suffix variable
     */
    public static boolean constructNaive(String target, List<String> wordBank) {

        // empty string means we reach the target using elements from the list
        if (target.isEmpty()) { return true; }

        for (String word : wordBank) {
            // if word is prefix of the target, we can remove it
            if (target.indexOf(word) == 0) {
                // get the rest of the word
                String suffix = target.substring(word.length());
                if (constructNaive(suffix, wordBank) == true) {
                    return true;
                }
            }
        }

        return false;
    }
    // ===============================================================================================
    /**
    * CAN CONSTRUCT DYNAMIC IMPLEMENATION
    * USING MEMOIZATION
     
     * m = target.length
     * n = wordBank.length
     * time complexity: O(n * (m ^ 2))
     * space complexity: O(m ^ 2)
     */
    public static boolean construct(String target, List<String> wordBank) {
        return constructMemoization(target, wordBank, new HashMap<>());
    }

    private static boolean constructMemoization(String target, List<String> wordBank, HashMap<String, Boolean> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        // empty string means we reach the target using elements from the list
        if (target.isEmpty()) { return true; }

        for (String word : wordBank) {
            // if word is prefix of the target, we can remove it
            if (target.indexOf(word) == 0) {
                // get the rest of the word
                String suffix = target.substring(word.length());
                if (constructMemoization(suffix, wordBank, memo) == true) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }
    // ===============================================================================================
    /**
    * CAN CONSTRUCT DYNAMIC IMPLEMENATION
    * USING TABULATION
     
     * m = target.length
     * n = wordBank.length
     * time complexity: O(m * n * m)
     * space complexity: O(m)
     */

     public static boolean constructTabulation(String target, List<String> wordBank) {

        boolean[] table = new boolean[target.length() + 1];
        for (int i = 0; i <= target.length(); i++) {
            table[i] = false;
        }

        // base case - empty string can always be constructed
        table[0] = true;

        for (int i = 0; i < table.length; i++) {

            if (table[i] == true) {
                for (String word : wordBank) {
                    // if the word matches the character starting at position i
                    if (target.substring(i).indexOf(word) == 0) {
                        table[i + word.length()] = true;
                    }

                }
            }

        }

        return table[target.length()];
     }

    // ===============================================================================================

    public static void main(String[] args) {
        System.out.println(constructTabulation("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(constructTabulation("skateboard", Arrays.asList("bo", "rd", "cd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(constructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                            Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
    }
    
}
