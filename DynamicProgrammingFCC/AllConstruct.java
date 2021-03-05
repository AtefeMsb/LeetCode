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
    // ===============================================================================================
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
    // ===============================================================================================
    /**
    * ALL CONSTRUCT DYNAMIC IMPLEMENATION
    * USING TABULATION
     
    * m = target.length
    * n = wordBank.length
    * time complexity: O(n ^ m)
    * space complexity: O(n ^ m)
    */

    public static List<List<String>> constructTabulation(String target, List<String> wordBank) {

        List<List<List<String>>> table = new ArrayList<>();
        table.add(new ArrayList<>());
        // space 0 has an empty array inside another array (2d)
        table.get(0).add(new ArrayList<>());

        for (int i = 0; i < target.length(); i++) { table.add(new ArrayList<>()); }

        for (int i = 0; i <= target.length(); i++) {
            if (table.get(i).isEmpty()) { continue; }
            // String word = target.substring(i);
            for (String word : wordBank) {
                if (target.substring(i).indexOf(word) != 0) { continue; }

                List<List<String>> current = table.get(i)
                    .stream()
                    .map(a -> new ArrayList<>(a))
                    .collect(Collectors.toList());

                current.forEach(arr -> arr.add(word));

                table.get(i + word.length()).addAll(current);
            }
        }
        return table.get(target.length());
    }

    // ===============================================================================================
    public static void main(String[] args) {

        System.out.println(constructTabulation("purple", Arrays.asList("purp", "le", "e", "purpl")));
        System.out.println(constructTabulation("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(constructTabulation("skateboard", Arrays.asList("bo", "rd", "cd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(constructTabulation("eeeeeeeeeeeeeeeeeeeef",
                            Arrays.asList("e", "ee", "eee", "eeee", "eeeee")));
    }

}
 