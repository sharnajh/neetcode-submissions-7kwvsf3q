class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
            "zxyzxyz"
             l r
        **/
        Set<Character> hist = new HashSet<>();
        int left = 0;
        int max = 0;
        
        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            while (hist.contains(c))
            {
                hist.remove(s.charAt(left));
                left++;
            }
            hist.add(c);
            
            int length = right - left + 1;
            if (length > max)
            {
                max = length;
            }
        }
        return max;
    }
}
