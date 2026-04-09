class MovingAverage {

    // stream of integers coming in. class initialize with size of window.
    // think of stream of integers adding to an array and the window is sliding window size.
    // calculating the average with each integer added to array as long as length does not
    // exceed the window size.

    // keep track of integers in stream
    private Queue<Integer> queue;
    private double sum;
    private int size;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;

        if (queue.size() > size)
        {
            sum -= queue.poll();
        }

        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */