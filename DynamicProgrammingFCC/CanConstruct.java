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
    public static void main(String[] args) {
        System.out.println(construct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(construct("skateboard", Arrays.asList("bo", "rd", "cd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(construct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                            Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
    }
    
}
