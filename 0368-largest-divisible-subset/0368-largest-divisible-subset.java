class Solution {
    List<Integer> ll=new ArrayList<>();
    int[] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        dp=new int[nums.length];
          Arrays.fill(dp,-1);
        Arrays.sort(nums);
        help(new ArrayList<>(),0,nums);
        return ll;
    }
    void help(List<Integer> l,int i,int[] n){
        if(i>=n.length){
            if(l.size()>ll.size()){
                ll.clear();
                ll.addAll(l);
                
            }
            return;
        }
        if(l.isEmpty()||(l.size()>dp[i]&& n[i]%l.get(l.size()-1)==0)){
            dp[i]=l.size();
            l.add(n[i]);
            help(l,i+1,n);
            l.remove(l.size()-1);
        }
        help(l,i+1,n);
    }
}