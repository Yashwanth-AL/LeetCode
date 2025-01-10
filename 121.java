class Solution {
    public int maxProfit(int[] prices) {
        int currentPrice = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > currentPrice) {
                profit = Math.max(profit, prices[i] - currentPrice); 
            } else {
                currentPrice = prices[i];
            }
        }
        return profit;
    }
}
