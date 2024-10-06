class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - minPrice;
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit < 0  ? 0 : maxProfit;
    }
}
