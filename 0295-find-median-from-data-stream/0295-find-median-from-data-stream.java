// class MedianFinder {

//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
        
//     }
    
//     public double findMedian() {
        
//     }
// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // min-heap (stores larger half)
    private PriorityQueue<Integer> minH = new PriorityQueue<>();

    // max-heap (stores smaller half)
    private PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        // do nothing
    }

    public void addNum(int num) {

        if (maxH.isEmpty()) {
            maxH.add(num);
            return;
        }

        // if number is <= max-heap top
        if (num <= maxH.peek()) {
            maxH.add(num);  // agr number maxHeap ki min value se chota hai too
        } else {
            minH.add(num);
        }

        // normalizing height balance
        while (minH.size() + 1 < maxH.size()) {
            minH.add(maxH.peek());
            maxH.poll();
        }

        while (minH.size() > maxH.size()) {
            maxH.add(minH.peek());
            minH.poll();
        }

        // value ko balance kro
        while (!minH.isEmpty() && !maxH.isEmpty() && minH.peek() < maxH.peek()) {
            minH.add(maxH.peek());
            maxH.poll();

            maxH.add(minH.peek());
            minH.poll();
        }
    }

    public double findMedian() {
        if (maxH.size() > minH.size()) {
            return maxH.peek();
        }
        if (!maxH.isEmpty() && !minH.isEmpty()) {
            return (maxH.peek() + minH.peek()) / 2.0;
        }
        return 0.0;
    }
}
