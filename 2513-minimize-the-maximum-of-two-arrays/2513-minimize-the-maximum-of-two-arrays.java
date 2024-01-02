class Solution {
    int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long l = 1,r = (int)(2 * 1e9);
        long ans = r;
        long lcm = (1L * divisor1 * divisor2) / gcd(divisor1,divisor2);
        for(;l <= r;){
            long mid = (l + r) >> 1;
            long x = mid - mid / divisor1;
            long y = mid - mid / divisor2;
            long z = mid - mid / lcm;
            if(x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2)) l = mid + 1;
            else{
                ans = Math.min(ans,mid);
                r = mid - 1;
            }
        }
        return (int)ans;
    }
}