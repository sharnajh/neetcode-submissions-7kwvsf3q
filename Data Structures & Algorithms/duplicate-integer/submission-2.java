class Solution {
    public boolean hasDuplicate(int[] nums) {
      /**
      HashSet
      **/

      HashSet<Integer> set = new HashSet<>();

      for(int num : nums)
      {
        if (set.contains(num))
        {
            return true;
        }
        else set.add(num);
      }

      return false;
    }
}