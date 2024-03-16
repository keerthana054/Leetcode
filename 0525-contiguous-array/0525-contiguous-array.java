import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        HashMap<Integer,Integer> countMap=new HashMap<>();
        countMap.put(0, -1);
        for (int i = 0; i < nums.length;i++) {
            count+=nums[i]==1?1:-1;
            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength,i-countMap.get(count));
            } else {
                countMap.put(count,i);
            }
        }
        
        return maxLength;
    }
}