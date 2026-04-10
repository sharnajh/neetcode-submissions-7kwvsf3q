class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;

        while (left < right)
        {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
            {
                int[] results = new int[2];
                results[0] = left + 1;
                results[1] = right + 1;
                return results;
            } 

            if (sum > target)
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return new int[2];
    }
}
