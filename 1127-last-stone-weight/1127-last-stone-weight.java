class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < n; i++ ) {
            maxHeap.add(stones[i]);
        }

        while(!maxHeap.isEmpty()) {
            int largest = maxHeap.poll();
            if (maxHeap.isEmpty()) {
                return largest;
            }
            int secondLargest = maxHeap.poll();
            int difference = largest - secondLargest;

            if(difference !=0) {
                maxHeap.add(difference);
            }
        }
        return 0;
    }
}