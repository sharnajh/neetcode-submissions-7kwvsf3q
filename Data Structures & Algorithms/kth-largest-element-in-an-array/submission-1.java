class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
            kth el from the end: length - k
            first solution that comes to mind:
            sorting the array (a-b), and returning the kth
            el from the end.
            not efficient because sorting is O(n log n);

            2 3 1 5 4
            1 2 3 4 5

            sort -> heap

            if we keep the heap to size kth
            add all the nums to the heap
            we can poll the kth largest
        */
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

        for (int num : nums)
        {
            minHeap.add(num);

            if (minHeap.size() > k)
            {
                // removing smallest in heap
                minHeap.poll();
            }
        }
        
        return minHeap.peek();

    }
}
