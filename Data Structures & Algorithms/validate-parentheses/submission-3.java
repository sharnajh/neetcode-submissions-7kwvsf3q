class Solution {
    public boolean isValid(String s) {
        // "([{}])"

        HashMap<Character,Character> ref = new HashMap<>();
        ref.put('}','{');
        ref.put(']','[');
        ref.put(')','(');

        // LIFO -> Stack
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray())
        {
            // if it is closing bracket
            if (ref.containsKey(c) && !stack.isEmpty())
            {
                if (stack.pop() != ref.get(c))
                {
                    return false;
                }
            }
            else
            {
                // if it is an opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
