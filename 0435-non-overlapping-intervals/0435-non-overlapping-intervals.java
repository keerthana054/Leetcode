class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int shift = 1 - min;
        int maxIntervalRange = 2 + max - min;
        int[] rightEnds = new int[maxIntervalRange];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right]) 
                rightEnds[right] = left;
        }

        int start = 1;
        int count = 1;
        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }

        return intervals.length - count;
    }
}