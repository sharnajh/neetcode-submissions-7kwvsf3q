class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // another optimized solution, using an array for frequency
        // instead of accumulating the counts, we just move it into an array
        // when we iterate through the ransom note, we look for that letter and remove 1
        // when there is no letter left, it returns false
        
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