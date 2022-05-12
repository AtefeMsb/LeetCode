import java.util.HashMap;
import java.util.Map;

/*
Smallest Window containing Substring
Given a string and a pattern, find the smallest substring in the given string
which has all the character occurrences of the given pattern.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }

    public static String findSubstring(String str, String pattern) {

        Map<Character, Integer> mapPattern = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            mapPattern.put(ch, mapPattern.getOrDefault(ch, 0) + 1);
        }

        int[] range = new int[2];
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        int required = mapPattern.size();
        int formed = 0;
        int minLen = str.length() + 1;

        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if (mapPattern.containsKey(rightChar) && mapPattern.get(rightChar) == map.get(rightChar)) {
                formed++;
            }

            // shrink the window
            while (left < right && formed == required) {

                if (right - left + 1 < minLen){
                    minLen = right - left + 1;
                    range[0] = left;
                    range[1] = right;
                }

                char leftChar = str.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                left++;

                if (mapPattern.containsKey(leftChar) && map.get(leftChar) < mapPattern.get(leftChar)) {
                    formed--;
                }

            }

        }

        return minLen == str.length() + 1 ? "" : str.substring(range[0], range[1] + 1);
    }
}