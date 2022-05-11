/*
Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
Sliding Window
*/

class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int k, int[] arr) {
      List<Double> list = new ArrayList<>();
      
      int left = 0;
      int sum = 0;
      for (int right = 0; right < arr.length; right++) {
        sum += arr[right];
        
        // when length of the subarray is k or more than k
        if (right - left + 1 >= k) {
          list.add((double)sum / k);
          sum -= arr[left];
          left++;
        }
      }
  
      double[] res = new double[list.size()];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }
  
    public static void main(String[] args) {
      double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
      System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
  }