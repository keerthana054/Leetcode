class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        ArrayList<String> ans = new ArrayList<String>();
        int i=0,j=0;
        final int n = nums.length;
        
        while(i<n){
            j=i;
            while(j+1<n && (long)nums[j+1]-nums[j] == 1){
                j++;
            }
            
            if(i==j){
                ans.add(String.valueOf(nums[i]));
                i++;
            }
            else{
                ans.add(String.valueOf(nums[i])+"->"+String.valueOf(nums[j]));
                j++;
                i=j;
            }
        }
        
        return ans;
        
    }
}