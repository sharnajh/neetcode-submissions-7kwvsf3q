class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // hashmap to track frequency of letters
        HashMap<Character,Integer> freq = new HashMap<>();

        for (char c : magazine.toCharArray())
        {
            // increasing frequency in map of char
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }

        for (char c : ransomNote.toCharArray())
        {
            // what happens if we need a letter for a ransom note, but there arent any left?
            if (!freq.containsKey(c) || freq.get(c) == 0)
            {
                return false;
            }

            // decrease frequency by 1
            // think: we just picked a letter out of mag to use in note
            freq.put(c, freq.get(c) - 1);
        }
        
        return true;
    }
}