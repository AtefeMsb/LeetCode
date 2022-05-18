// two pointers
// time: O(n)
// space: O(1)
/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }


    public static int[] search(int[] arr, int targetSum) {
        int[] res = new int[2];
        int left = 0;
        int right = arr.length - 1;
        int sum = 9;

        while (left < right) {
            sum = arr[left] + arr[right];

            if (sum > targetSum) {
                right--;
            } else if (sum < targetSum) {
                left++;
            } else if (sum == targetSum) {
                return new int[] {left, right};
            }
        }

        return new int[] {-1, -1};
    }
}

// ---------------------------------------------------------
// hashmap - two sum
// time: O(n)
// space: O(n)
public static int[] search(int[] arr, int targetSum) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        int diff = targetSum - arr[i];
        if (map.containsKey(diff)) {
            return new int[] {map.get(diff), i};
        }
        map.put(arr[i], i);
    }
    return new int[] {-1, -1};
}