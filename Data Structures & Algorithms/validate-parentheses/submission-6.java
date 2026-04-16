class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        // stack = ([{ }])

        Stack<Character> openings = new Stack<>();

        for (char c : s.toCharArray())
        {
            if (map.containsKey(c)) openings.push(c);
            else
            {
                if(openings.isEmpty() || map.get(openings.pop()) != c) return false;
            }
        }

        return (openings.isEmpty()) ? true : false;
    }
}
