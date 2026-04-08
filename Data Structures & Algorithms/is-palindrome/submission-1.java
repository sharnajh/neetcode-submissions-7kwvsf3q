class Solution {
    public boolean isPalindrome(String s) {
        /**

        Requirements:
        1. Clean the string of non-letters and make all letters lowercase (or uppercase).
        2. Check if value of index 0 matches n.

        Possible solutions:
        1. "Brute force" methods.

            A for loop to iterate through the string to filter -> O(n)

            A double for loop iterating through the cfiltered string.
            (i) Parent for loop: 0 ... n. -> O(n)
            (j) Nested for loop: n ... 0. -> O(n)
            With each iteration, check if value of i and j are the same. 
            Total time complexity is: O(n^3)

        2. Two Pointers

            Use two pointers starting from both ends of the string.
            While moving the pointers inward, we:
                - check for alphanumeric
                - compare letters with case-sensitivity
            Total time complexity: O(n/2) -> O(n)
        */

        // set up pointers
        int left = 0;
        int right = s.length() - 1;

        // process of determing if it is not a palindrome
        while(left < right)
        {
            // skip non alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }

            // skip non alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }

            // check if char at either ends does not match
            if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left)))
            {
                return false;
            }

            // continue processing
            left++;
            right--;
        }

        return true;
    }
}
