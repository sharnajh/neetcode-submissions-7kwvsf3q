class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int max = 0;

        for (int num : set)
        {
            // check if num is a portential start of a sequence
            if (!set.contains(num - 1)) {
                int count = 1;
                int curr = num;
                // check for rest of sequence
                while (set.contains(curr + 1))
                {
                    curr++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}