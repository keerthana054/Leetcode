class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minProfit = prices[0];
        for(int i=0;i<prices.length;i++){
            minProfit = Math.min(minProfit,prices[i]);
            int profit = prices[i] - minProfit;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}