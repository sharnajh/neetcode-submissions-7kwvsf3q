class Solution {
    /**
    a = l x w

    
    **/
    
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int rainwater = 0;
        while (left < right)
        {
            if (maxLeft < maxRight)
            {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                rainwater += maxLeft - height[left];
            }
            else
            {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                rainwater += maxRight - height[right];
            }
        }
        return rainwater;
    }
}