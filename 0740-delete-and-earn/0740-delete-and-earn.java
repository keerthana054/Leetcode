class Solution {
    public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i:nums){
                hm.put(i,hm.getOrDefault(i,0)+1);
            }
            Integer dp[][] = new Integer[nums.length+1][100];
            return help(nums, hm, 0, dp, 0);
        }
        public int help(int nums[], HashMap<Integer, Integer> hm, int i, Integer dp[][], int prev){
            if(i>=nums.length){
                return 0;
            }
            if(dp[i][prev]!=null){
                return dp[i][prev];
            }
            boolean f1=false;
            int pick = 0, n_pick=0,freq=0;
            if(hm.get(nums[i])>0){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.containsKey(nums[i]+1)){
                    freq=hm.get(nums[i]+1);
                    hm.put(nums[i]+1,0);
                    f1=true;
                }
                pick=nums[i]+help(nums,hm,i+1,dp, nums[i]%100);
                hm.put(nums[i],hm.get(nums[i])+1);
                if(f1){
                    hm.put(nums[i]+1,freq);
                }
                n_pick = Math.max(n_pick, help(nums,hm,i+1,dp,prev));
            }
            else{
                n_pick=Math.max(n_pick, help(nums, hm,i+1,dp, prev));
            }
            return dp[i][prev]=Math.max(pick, n_pick);

    }
}