class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int compliment = target - nums[i];
            if(numMap.containsKey(compliment)) {
                return new int[]{numMap.get(compliment), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}