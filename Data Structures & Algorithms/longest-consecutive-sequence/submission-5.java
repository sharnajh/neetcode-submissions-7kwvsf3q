class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // adding unique elements to set
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums)
        {
            unique.add(num);
        }

        int max = 0;
        // at each iteration, check if it is a beginning sequence (set does not contain val - 1)
        // do while loop to check if val + 1 is in set and increment count
        // add if max value
        for (int i = 0; i < nums.length; i++)
        {
            int count = 1;
            int curr = nums[i];
            if (!unique.contains(curr - 1))
            {
                while (unique.contains(curr + 1))
                {
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }

        }

        return max;
    }
}