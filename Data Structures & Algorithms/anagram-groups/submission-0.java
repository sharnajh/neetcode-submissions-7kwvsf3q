class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
            to check for anagram,
            keep frequency of chars
            and check strings against that.
        **/
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> groups = new HashMap<>();

        for (String s : strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String group = new String(arr);
            
            groups.computeIfAbsent(group, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
