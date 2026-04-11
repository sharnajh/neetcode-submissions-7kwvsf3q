class Solution {
    public boolean isAnagram(String s, String t) {
        /**
        lowercase?
        **/

        // HashMap<Character,Integer> hist = new HashMap<>();
        // for (char c : s.toCharArray())
        // {
        //     hist.put(c, hist.getOrDefault(c, 0) + 1);
        // }

        // for (char c : t.toCharArray())
        // {
        //     if (hist.containsKey(c) && hist.get(c) > 0)
        //     {
        //         hist.put(c, hist.get(c) - 1);
        //     }
        //     else
        //     {
        //         return false;
        //     }
        // }
        // return true;

        if (s.length() != t.length()) return false;

        // alphabet
        int[] alphabet = new int[26];
        for (char c : s.toCharArray())
        {
            alphabet[c - 'a']++; 
        }

        for (char c : t.toCharArray())
        {
            if (alphabet[c - 'a'] > 0)
            {
                alphabet[c - 'a']--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
