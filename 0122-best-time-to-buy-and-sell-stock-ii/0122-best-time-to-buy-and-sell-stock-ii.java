class Solution {
    public int maxProfit(int[] prices) {
        int minProfit = prices[0];
        int diff = 0;
        int result = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                diff = Math.max(diff,prices[i]-minProfit);
            }
            else {
                minProfit = prices[i];
                result+=diff;
                diff=0;
            }
        }
        return result+diff;
        
    }
}