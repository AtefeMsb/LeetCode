package DynamicProgrammingFCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * COMBINATORIC PROBLEM: number of ways possible that the target word be
 * constructed by concatenating elements of the string array.
 * 
 * @param target
 * @param wordBank
 */
public class CountConstruct {

    /**
     * COUNT CONSTRUCT NAIVE IMPLEMENATION
     * 
     * m = target.length
     * n = wordBank.length
     * time complexity: O(n ^ m * m) second m: is because of finding substring
     * space complexity: O(m * m) first m: depth of the tree - second m: suffix variable
     */

    public static int constructNaive(String target, List<String> wordBank) {

        if (target.isEmpty()) { return 1;}
       
        int totalCount = 0;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = constructNaive(suffix, wordBank);
                totalCount += numWaysForRest;  
                }
            }

            return totalCount;
        }

    // ===============================================================================================
    /**
    * COUNT CONSTRUCT DYNAMIC IMPLEMENATION
    * USING MEMOIZATION
     
     * m = target.length
     * n = wordBank.length
     * time complexity: O(n * (m ^ 2))
     * space complexity: O(m ^ 2)
     */
    public static int count(String target, List<String> wordBank) {
        return countMemoize(target, wordBank, new HashMap<>());
    }
    private static int countMemoize(String target, List<String> wordBank, HashMap<String, Integer> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) { return 1;}
        
        int totalCount = 0;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = countMemoize(suffix, wordBank, memo);
                totalCount += numWaysForRest;  
                }
            }

            memo.put(target, totalCount);
            return totalCount;
        }
    // ===============================================================================================
    /**
    * COUNT CONSTRUCT DYNAMIC IMPLEMENATION
    * USING TABULATION
     
     * m = target.length
     * n = wordBank.length
     * time complexity: O(n * (m ^ 2))
     * space complexity: O(m)
     */

    public static int countTabulation(String target, List<String> wordBank) {
        int[] table = new int[target.length() + 1];
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }
        table[0] = 1;

        for (int i = 0; i < table.length; i++) {
            for (String word : wordBank) {

                // if the word matches the character starting at position i
                if (target.substring(i).indexOf(word) == 0) {
                    table[i + word.length()] += table[i];

                }

            }
            
        }

        return table[target.length()];
    }
    // ===============================================================================================
    public static void main(String[] args) {

        System.out.println(countTabulation("purple", Arrays.asList("purp", "le", "e", "purpl")));
        System.out.println(countTabulation("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countTabulation("skateboard", Arrays.asList("bo", "rd", "cd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                            Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
    }
}
