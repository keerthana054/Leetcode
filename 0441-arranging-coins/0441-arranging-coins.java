class Solution {
    public int arrangeCoins(int n) {
        int st = 0;
        int end = n;

        while(st<=end){
            double mid = st + (end-st)/2;

            if(mid*(mid+1)/2>n) end = (int)mid-1;
            else if(mid*(mid+1)/2<n) st = (int)mid+1;
            else return (int)mid;
        }
        return end;
    }
}
