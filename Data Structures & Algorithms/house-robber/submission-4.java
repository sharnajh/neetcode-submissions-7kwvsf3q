class Solution {
    public int rob(int[] nums) {
        
        int rob1 = 0;
        int rob2 = 0;
        int[] maxAmt = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            int max = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = max;
            maxAmt[i] = rob2;
        }
        return maxAmt[nums.length-1];
    }
}