package DynamicProgrammingFCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * returns a 2D array of all the ways possible that the target word be
 * constructed by concatenating elements of the string array.
 * 
 * @param target
 * @param wordBank
 */

public class AllConstruct {

    /**
     * ALL CONSTRUCT NAIVE IMPLEMENATION
     */
    public static List<List<String>> constructNaive(String target, List<String> wordBank) {

        if (target.isEmpty()) {
            return Arrays.asList(new ArrayList<String>()); 
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = constructNaive(suffix, wordBank);

                // add the current word to each list in the list of lists
                suffixWays
                .stream()
                .map(arr -> new ArrayList<>(arr))
                .collect(Collectors.toList());
                
                // add the current world infront of each list
                suffixWays.forEach(arr -> arr.add(0, word));
                result.addAll(suffixWays);

            }
        }

        return result;
    }

    /**
    * ALL CONSTRUCT DYNAMIC IMPLEMENATION
    * USING MEMOIZATION
     
    * m = target.length
    * n = wordBank.length
    * time complexity: O(n ^ m) number of combinations/number of leaves
    * space complexity: O(m) heaight of recursion tree
     */
    public static List<List<String>> construct(String target, List<String> wordBank) {
        return constructMemoization(target, wordBank, new HashMap<>());
    }
    private static List<List<String>> constructMemoization(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return Arrays.asList(new ArrayList<String>()); 
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = constructMemoization(suffix, wordBank, memo);

                // add the current word to each list in the list of lists
                suffixWays
                .stream()
                .map(arr -> new ArrayList<>(arr))
                .collect(Collectors.toList());
                
                // add the current world infront of each list
                suffixWays.forEach(arr -> arr.add(0, word));
                result.addAll(suffixWays);

            }
        }

        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(construct("purple", Arrays.asList("purp", "le", "e", "purpl")));
        System.out.println(constructNaive("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(constructNaive("skateboard", Arrays.asList("bo", "rd", "cd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(constructNaive("eeeeeeeeeeeeeeeeeeeef",
                            Arrays.asList("e", "ee", "eee", "eeee", "eeeee")));
    }

}
 