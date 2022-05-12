import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
String Anagrams (hard)
Given a string and a pattern, find all anagrams of the pattern in the given string.

Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters
while finding permutations of a string, we get N! permutations (or anagrams) of a string having N
characters. For example, here are the six anagrams of the string “abc”:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 */
public class StringAnagrams {
    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matched = 0;
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);

                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                resultIndices.add(left);
            }

            if (right >= pattern.length() - 1) {
                char leftChar = str.charAt(left);
                left++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                        matched--;
                    }
                }

            }
        }

        return resultIndices;
    }
}