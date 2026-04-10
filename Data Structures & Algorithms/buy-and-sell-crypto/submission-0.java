class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        for (int i = 0; i < prices.length; i++)
        {
            int right = i + 1;
            while (right < prices.length)
            {
                int profit = prices[right] - prices[i];
                if(profit > max)
                {
                    max = profit;
                }
                right++;
            }
        }
        return max;
    }
}
