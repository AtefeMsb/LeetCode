import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.
The above algorithm’s time complexity will be O(N), where N is the number of characters in the input string.
The outer for loop runs for all characters, and the inner while loop processes each character only once;
therefore, the time complexity of the algorithm will be O(N+N)
, which is asymptotically equivalent to O(N)
 */
public class LongestSubstringKDistinct {
    public static void main(String[] args) {

        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }

    private static int findLength(String input, int k) {
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < input.length(); right++) {

            char rightChar = input.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // if window not a valid substring, shrink the window from left
            while (left < right && map.size() > k) {
                char leftChar = input.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}