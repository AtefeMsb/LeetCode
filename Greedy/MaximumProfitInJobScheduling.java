// dp[end_time] = max profit can be obtained from time 0 to end_time

// induction rule
// for each job = [s, e, p], where s = start time, e = end time, p = profit,
// case 1: don't do this job  -> nothing changes, dp[end_time] = dp[previous end_time]
// case 2: do this job -> dp[end_time] = dp[previous end_time <= s that gives max profit] + p
//         find the max profit we can make before start time s (using binary search), so we can know the max profit we can make after doing this job
// Therefore,
// dp[end_time] = max( dp[previous end_time],  dp[previous end_time <= s that gives max profit] + p )

// base case
// dp[0] = 0 as we make profit = 0 at time = 0.

class Solution {
    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        
        // 1. create array of Job
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // 2. sort the jobs based on their end time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0); 
        dpProfit.add(0);

        for (Job job : jobs) {
            // find the biggest profit from the previous jobs
            int prevIdx = largestSmaller(dpEndTime, job.start + 1); 
            
            int taken = dpProfit.get(prevIdx) + job.profit;
            int nonTaken = dpProfit.get(dpProfit.size() - 1);
            
            if (taken > nonTaken) {
                dpEndTime.add(job.end);
                dpProfit.add(taken);
            }
        }

        // return the last lement from profit table
        return dpProfit.get(dpProfit.size() - 1);
    }

    // If we do this job, binary search in the dp to find the largest profit we can make before start time 
    private int largestSmaller(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return list.get(right) < target ? right : left;
    }
}