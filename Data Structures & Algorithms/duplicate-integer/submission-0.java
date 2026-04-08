class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<Integer>();

        for (int x : nums)
        {
            if (hash.contains(x))
            {
                return true;
            }
            hash.add(x);
        }
        return false;
    }
}
