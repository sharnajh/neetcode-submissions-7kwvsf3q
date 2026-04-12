class KthLargest {

    private int k;
    private int[] nums;
    private PriorityQueue<Integer> strm;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.strm = new PriorityQueue<>((a,b) -> a - b);
        
        for (int num : nums)
        {
            this.strm.add(num);
            if (this.strm.size() > k)
            {
                strm.poll();
            }
        }
    }
    
    public int add(int val) {
        strm.add(val);

        if (strm.size() > k)
        {
            strm.poll();
        }

        return strm.peek();
    }
}
