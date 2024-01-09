class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        int res=0;
        int sign=(dividend>0)==(divisor>0)?1:-1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend - divisor >= 0){
            int temp = divisor;
            int count = 1;
            while(dividend - (temp<<1)>=0){
                temp<<=1;
                count<<=1;
                
            }res+=count;
            dividend -= temp;
        }
        return res*sign;
    }
}