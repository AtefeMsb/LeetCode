class Main {

    private static int binarySearch(int[] list, int target) {
  
      int low = 0;
      int high = list.length - 1;
      int mid = 0;
      int firstIndex = -1;
  
      while (low <= high) {
        mid = low + (high - low) / 2;
        if (list[mid] == target) {
          firstIndex = mid;
          high = mid - 1;
        } else if (list[mid] < target) {
          low = mid + 1;
        } else if (list[mid] > target) {
          high = mid - 1;
        }
      }
        return firstIndex;
    }
  
    public static void main(String[] args) {
      System.out.println("Hello world!");
      int[] list = new int[]{1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 6};
      System.out.println("the first occurance index is:" + binarySearch(list, 4));
    }
  }