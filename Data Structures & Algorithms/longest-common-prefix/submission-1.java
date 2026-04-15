class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);

            for (String s : strs) 
            { 
                if (i >= s.length() || s.charAt(i) != c) 
                { 
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}