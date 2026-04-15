class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // not taken solution: iterate through the string, sort it, do another for loop, compare it with every other sorted string.
        // O(n^2) ... Array.sort() X

        // Optimed solution: O(n)

        // data struct holding with key = anagram, and value = live of strings that apply
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        // loop through strs
        // -> character freq array during each iteration
        // -> convert the freq array into the key anagram
        // -> data struct. key = anagram. value = string.
        for (String s : strs)
        {
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i++)
            {
                alphabet[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(alphabet);

            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // create result array, push all values in map to array
        List<List<String>> result = new ArrayList<>();
        for (String key : anagramGroups.keySet())
        {
            result.add(anagramGroups.get(key));
        }

        // return array
        return result;
    }
}