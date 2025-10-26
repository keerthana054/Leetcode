class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pair = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(pair.containsKey(target-num)) {
                return new int[] { i, pair.get(target-num)};
            }

            pair.put(num, i);
        } 

        return new int[] {};
    }
}