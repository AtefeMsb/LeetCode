import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring, which has all distinct characters.
time complexity will be O(N)
*/
public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }

    private static int findLength(String input) {
        int maxLen = 0;

        // HashMap to remember the last index of each character we have processed.
        // Whenever we get a duplicate character, we will shrink our sliding window
        // to ensure that we always have distinct characters in the sliding window.
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < input.length(); right++) {
            char rightChar = input.charAt(right);

            if (map.containsKey(rightChar)) {
                int lastIndexOccurence = map.get(rightChar);
                // we should make sure we move left to after the current position
                left = Math.max(left, lastIndexOccurence + 1);
            }

            map.put(rightChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

