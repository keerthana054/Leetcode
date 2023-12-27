class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
     int n = nums.size();
     int res = 0;
     for(int i = 0; i < n; i++) 
        if(Integer.bitCount(i) == k)
          res += nums.get(i);
     return res;   
    }
}