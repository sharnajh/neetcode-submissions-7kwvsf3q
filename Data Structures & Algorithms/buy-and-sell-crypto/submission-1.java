class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int j;
        for (int i = 0; i < prices.length; i++)
        {
            j = i + 1;
            while (j < prices.length)
            {
                max = Math.max(max, prices[j] - prices[i]);
                j++;
            }
        }

        return max;
    }
}
