class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // keep track of the frequency of each num
        HashMap<Integer,Integer> freqs = new HashMap<>();
        for (int num : nums)
        {
            // increment freq for num
            freqs.put(num, freqs.getOrDefault(num,0) + 1);
        }

        // determine the k most frequent
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> freqs.get(a) - freqs.get(b));
        for (int num : freqs.keySet())
        {
            // add to heap, will get sorted to the top
            heap.add(num);

            if (heap.size() > k)
            { // get rid of smallest on top
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
        {
            res[i] = heap.poll();
        }
        return res;
    }
}
