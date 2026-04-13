class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs)
        {
            encodedString.append(s.length()).append("#").append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> strs2 = new ArrayList<>();
        while (i < str.length())
        {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            strs2.add(str.substring(i, i + length));
            i += length;
        }
        return strs2;
    }
}