class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            sum+=nums[i];
        }
        while(k!=0&&!pq.isEmpty())
        {
            int x=pq.remove();
            if(x<0){
                int y=-x;
                sum=sum+y+y;
            }
            else{
                sum=sum-x-x;
            }
            pq.add(-x);
            k--;
        }
        return sum;
    }
}