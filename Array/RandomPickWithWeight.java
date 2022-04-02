// Prefix Sums with Linear Search
class Solution {
    // cumulative sum array
    int[] prefixSums;
    int totalSum;
    Random random;

    public Solution(int[] w) {
        prefixSums = new int[w.length];

        int sum = 0;
        for (int i = 0; i < w.length; ++i) {
            sum += w[i];
            prefixSums[i] = sum;
        }
        
        totalSum = sum;
        random = new Random();
    }

    public int pickIndex() {
        int index = random.nextInt(totalSum) + 1;
        
        // run a linear search to find the bucket index is in
        for (int i = 0; i < prefixSums.length; ++i) {
            if (index < prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return 0;
  }
}
// ---------------------------------------------------
// Prefix Sums with Binary Search
class Solution {
    // cumulative sum array
    int[] prefixSums;
    int totalSum;
    Random random;

    public Solution(int[] w) {
        prefixSums = new int[w.length];

        int sum = 0;
        for (int i = 0; i < w.length; ++i) {
            sum += w[i];
            prefixSums[i] = sum;
        }
        
        totalSum = sum;
        random = new Random();
    }

    public int pickIndex() {
        int index = random.nextInt(totalSum) + 1;
        
        int low = 0;
        int high = prefixSums.length - 1;
        
        while (low < high) {
            
            int mid = low + (high - low) / 2;
            if (index < prefixSums[mid]) {
                high = mid - 1;
            } else if (index > prefixSums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
            
        }
        
        // would never get to this return
        return 0;
        
  }
}