class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**

        Brute force:
            Double for loop.
                for loop i .. n
                for loop j .. n (j+1)
                check if i+j = target
            time complexity is O(n^2)

        */

        // Store all integers and their indices
        HashMap<Integer,Integer> prev = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            // unoptimized solution: just loop through the hashmap to calculate what will complement current num

            int complement = target - nums[i];

            if (prev.containsKey(complement))
            {
                return new int[]{prev.get(complement), i};
            }

            prev.put(nums[i], i);
        }

        // return default value
        return new int[]{};
    }
}
