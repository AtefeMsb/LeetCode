// Approach 1: Brute Force with Hashmap
// Time Complexity and Space Complexity : O(n)

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for (int num : arr1) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
         for (int num : arr2) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
         for (int num : arr3) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : arr1) {
            if (frequency.containsKey(num) && frequency.get(num) == 3) {
                result.add(num);
            }
        }
        
        return result;
    }
}


///////////////////////////////////////////////////////////////
// Approach 2: Three Pointers
// Time Complexity: O(n)
// Space Complexity : O(1)

class Solution2 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList <>();
        // prepare three pointers to iterate through three arrays
        // p1, p2, and p3 point to the beginning of arr1, arr2, and arr3 accordingly
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {

            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                ans.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                if (arr1[p1] < arr2[p2]) {
                    p1++;
                } else if (arr2[p2] < arr3[p3]) {
                    p2++;
                } else {
                    p3++;
                }

            }
        }
        return ans;
    }
}