package hard;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Solution295 {

    public static void main(String[] args){
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }



    static class MedianFinder {

        private Queue<Integer> minHeap;
        private Queue<Integer> maxHeap;

        private int sumSize = 0;

        public MedianFinder() {
            minHeap=new PriorityQueue<>(Comparator.comparingInt(o -> o));
            maxHeap=new PriorityQueue<>((o1, o2) -> o2-o1);
        }

        public void addNum(int num) {
            if (maxHeap.size()==0){
                maxHeap.add(num);
            }
            else if (num<maxHeap.peek()){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
            sumSize++;
            reblance();
        }

        public double findMedian() {
            if (sumSize==0) return 0;
            if (sumSize%2==0){
                return 1.0*(maxHeap.peek()+ minHeap.peek())/2;
            }
            else{
                if (maxHeap.size()> minHeap.size()){
                    return maxHeap.peek();
                }
                else{
                    return minHeap.peek();
                }
            }

        }

        private void reblance(){
            if (sumSize%2==0){
                if (maxHeap.size()>minHeap.size()){
                    minHeap.add(maxHeap.poll());
                }
                if (maxHeap.size()<minHeap.size()){
                    maxHeap.add(minHeap.poll());
                }
            }
            else{
                if (maxHeap.size()>minHeap.size()+1){
                    minHeap.add(maxHeap.poll());
                }
                if (minHeap.size()>maxHeap.size()+1){
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

}
