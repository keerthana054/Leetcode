class Solution {
        private class Job {
        private int startTime;
        private int endTime;
        private int profit;

        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i=0; i<startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, (a,b) -> a.endTime - b.endTime);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;

        for(Job currJob : jobs) {
            Integer entryTillStartTime = map.floorKey(currJob.startTime);
            int maxProfitStartTime = entryTillStartTime==null ? 0 : map.get(entryTillStartTime);
            ans = Math.max(ans, maxProfitStartTime + currJob.profit);
            map.put(currJob.endTime, ans);
        }
        return ans;
    }
}