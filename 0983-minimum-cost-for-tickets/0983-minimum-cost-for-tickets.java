class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         int[] dp = new int[days.length + 1];
        int n = days.length;

        for (int i = n - 1; i >= 0; i--) {
            int day7 = i, day30 = i;

            while (day7 < n && days[day7] < days[i] + 7)
                day7++;

            while (day30 < n && days[day30] < days[i] + 30)
                day30++;

            dp[i] = Math.min(costs[0] + dp[i + 1], Math.min(costs[1] + dp[day7], costs[2] + dp[day30]));
        }

        return dp[0];
    }
}