class Solution {
    public int lastStoneWeight(int[] stones) {
        // sort stones to get the heaviest
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone : stones)
        {
            heap.add(stone);
        }


        while(heap.size() >= 2)
        {
            // get 2 heaviest stones in heap
            int x = heap.poll();
            int y = heap.poll();
            
            if (x < y)
            {
                heap.add(y-x);
            }
            else 
            {
                heap.add(x-y);
            }
        }

        if (!heap.isEmpty())
        {
            return heap.poll();
        }
        return 0;
    }
}
