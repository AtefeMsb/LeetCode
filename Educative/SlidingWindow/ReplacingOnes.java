/*
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.
 */
public class ReplacingOnes {
    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }

    public static int findLength(int[] arr, int k) {

        int maxLen = 0;
        int oneCount = 0;

        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 1) {
                oneCount++;
            }

            while ((right - left + 1) - oneCount > k) {
                if (arr[left] == 1) {
                    oneCount--;
                }
                left++;
            }

            maxLen = Math.max(right - left + 1, maxLen);
        }

        return maxLen;
    }
}