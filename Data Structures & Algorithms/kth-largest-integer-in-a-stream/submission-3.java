class KthLargest {

    int k;
    int[] nums;

    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
        this.heap = new PriorityQueue<>((a,b) -> a - b);

        for (int num : nums)
        {
            addToHeap(num);
        }
    }

    public void addToHeap(int val)
    {
        heap.add(val);
        if (heap.size() > k)
        {
            heap.poll();
        }
    }
    
    public int add(int val) {
        addToHeap(val);
        if (heap.isEmpty()) return val;
        return heap.element();
    }
}
