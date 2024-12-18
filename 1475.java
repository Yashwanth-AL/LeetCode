class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();

        for(int i = 0; i < prices.length - 1; i++) {
            int index = i;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] <= prices[i]) {
                    index = j;
                    break;
                }
            }
            if(index != i) {
                result[i] = prices[i] - prices[index];
            }
        }
        return result;
    }
}
