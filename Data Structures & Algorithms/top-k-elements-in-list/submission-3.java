class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for (int num : map.keySet())
        {
            int[] keyValue = new int[2];
            keyValue[0] = num;
            keyValue[1] = map.get(num);
            heap.add(keyValue);

            if (heap.size() > k)
            {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
        {
            result[i] = heap.poll()[0];
        }

        return result;
    }
}
