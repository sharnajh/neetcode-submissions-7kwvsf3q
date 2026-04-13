class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // freq array
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            char m = Character.toLowerCase(s.charAt(i));
            chars[m - 'a'] += 1;
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            char m = Character.toLowerCase(t.charAt(i));
            if (chars[m - 'a'] > 0)
            {
                chars[m - 'a'] -= 1;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
