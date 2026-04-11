class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        // a = w x h
        // maxArea = (right - left) x min(left,right)
        int maxArea = 0;
        while (left < right)
        {
            int length = right - left;
            int area = (length) * Math.min(heights[left],heights[right]);
            maxArea = Math.max(maxArea, area);

            if (heights[left] > heights[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return maxArea;
    }
}
