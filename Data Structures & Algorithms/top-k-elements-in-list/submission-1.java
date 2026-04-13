class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet())
        {
            int[] keyValuePair = new int[2];
            keyValuePair[0] = (key);
            keyValuePair[1] = (map.get(key));
            q.add(keyValuePair);
            if (q.size() > k)
            {
                q.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.poll()[0];
        }
        return result;
    }
}
