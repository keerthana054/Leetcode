class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int numsLength = nums.length;
        boolean[] isPresent = new boolean[numsLength + 1];

        for(int num:nums){
            isPresent[num] = true;
        } 

        List<Integer> missing = new ArrayList<>();
        for(int i=1; i<=numsLength;i++){
            if(!isPresent[i]){
                missing.add(i);
            }
        }

        return missing;
    }
}