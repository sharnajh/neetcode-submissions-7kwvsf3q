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
        HashMap<Integer,Integer> hist = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            int complement = target - num;
            if (hist.containsKey(complement))
            {
                int[] result = {hist.get(complement),i};
                return result;
            }
            hist.put(num, i);
        }

        return null;
    }
}
