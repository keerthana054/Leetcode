class Solution {
    public int countDigits(int num) {
        int count = 0;
        int n=num;
        while(num!=0)
        {
            int k=num%10;
            if(n%k==0)
            {
                count++;
            }
            num/=10;
        }
        return count; 
    }
}