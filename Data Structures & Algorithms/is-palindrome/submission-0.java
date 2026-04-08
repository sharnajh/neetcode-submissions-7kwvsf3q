class Solution {
    public boolean isPalindrome(String s) {
        int x = 0;
        int y = s.length() - 1;

        while (x < y)
        {
            // Increment/decrement x or y to skip non-alphanumeric chars
            while (x < y && !Character.isLetterOrDigit(s.charAt(x)))
            {
                x++;
            }
            while (x < y && !Character.isLetterOrDigit(s.charAt(y)))
            {
                y--;
            }

            // early return false if not a match
            if (Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y)))
            {
                return false;
            }

            // move onto next iteration in string
            x++;
            y--;
        }

        // all conditions should be met
        return true;
    }
}
