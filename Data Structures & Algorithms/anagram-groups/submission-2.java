class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
            to check for anagram,
            keep frequency of chars
            and check strings against that.
        **/
        HashMap<String,List<String>> groups = new HashMap<>();

        for (String s : strs)
        {
            int[] count = new int[26];
            for (char c : s.toCharArray())
            {
                count[c - 'a']++;
            }
            String group = Arrays.toString(count);
            
            groups.computeIfAbsent(group, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
