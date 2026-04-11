class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];

            if (map.containsKey(complement))
            {
                int[] result = new int[2];
                result[0] = (map.get(complement));
                result[1] = (i);
                return result;
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
