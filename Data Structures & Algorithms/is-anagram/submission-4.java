class Solution {
    public boolean isAnagram(String s, String t) {
        /**
        1. Constraints: length? non-alphanumeric? 
        2. Ask for example inputs
    
        */
        if (s.length() != t.length()) return false;
        // keep track of the counts of letters in first string
        HashMap<Character,Integer> hist = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (char el : sArr)
        {
            hist.put(el, hist.getOrDefault(el,0) + 1);
        }

        // iterate through second string against those counts
        char[] tArr = t.toCharArray();
        for (char el : tArr)
        {
            // if letter does not exist in other string
            if (!hist.containsKey(el)) return false;

            // decrease the count
            hist.put(el, hist.get(el) - 1);

            // if not enough similar letters
            if (hist.get(el) < 0) return false;
        }


        return true;
    }
}
