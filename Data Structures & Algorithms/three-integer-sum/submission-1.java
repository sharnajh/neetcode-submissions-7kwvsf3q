class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);

                    boolean exists = false;
                    for (List<Integer> arr : results)
                    {
                        if (arr.equals(res)) exists = true;
                    }
                    if (!exists) results.add(res);
                    j++;
                    k--;
                }
                else if (sum < 0)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return results;
    }
}
