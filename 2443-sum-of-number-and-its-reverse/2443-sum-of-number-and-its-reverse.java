class Solution {
    private int rev(int n){
        int res = 0;
        while(n > 0){
            res = res*10 + n % 10;
            n /= 10;
        }
        return res;
    }
    public boolean sumOfNumberAndReverse(int num) {
        int j;
        for(int i = num / 2; i <= num; i++)
            if(i + rev(i) == num) return true;
        return false; 
    }
}