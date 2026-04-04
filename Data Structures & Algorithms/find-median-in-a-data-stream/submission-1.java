class MedianFinder {

    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(lo.isEmpty() || lo.peek() >= num){
            lo.offer(num);
        }
        else {
            hi.offer(num);
        }

        if (lo.size() < hi.size()){
            lo.offer(hi.poll());
        }
        else if (lo.size() > hi.size() + 1){
            hi.offer(lo.poll());
        }
    }
    
    public double findMedian() {
        if (lo.size() == hi.size())
            return (lo.peek() + hi.peek()) / 2.0;
        return lo.peek();
    }
}
