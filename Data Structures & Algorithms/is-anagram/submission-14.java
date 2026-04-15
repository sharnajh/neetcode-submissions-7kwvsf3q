class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            alphabet[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            if (alphabet[c - 'a'] <= 0)
            {
                return false;
            }
            alphabet[c - 'a']--;
        }

        return true;
    }
}
