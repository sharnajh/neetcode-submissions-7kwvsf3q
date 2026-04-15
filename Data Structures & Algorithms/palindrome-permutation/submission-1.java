class Solution {
    /**
        Palindrome can only have at most 1 odd freq for a char. the other chars has to have equal amounts on both sides.
    **/
    public boolean canPermutePalindrome(String s) {
        
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] % 2 != 0) oddCount++;
        }

        return oddCount <= 1;
    }
}
