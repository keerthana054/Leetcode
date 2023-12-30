class Solution {
    public int numberOfSteps(int num) {
        return steps(num,0);
}
    public int steps(int num, int ans){
        if(num==0){
            return ans;
        }
        else if(num%2==0){
            return steps(num/2, ans+1);
        }
        else{
            return steps(num-1,ans+1);
        }
    }
}