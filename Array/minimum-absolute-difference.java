class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        // first find the minimum abseloute diffrence 
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int tempMin = Math.abs(arr[i] - arr[i - 1]);
            min = Math.min(min, tempMin);
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                results.add(pair);
            }
        }
        return results;
    }
}
