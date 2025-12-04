class Solution {
    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;

        while(left<=right && directions.charAt(left)=='L') left++;
        while(right>=left && directions.charAt(right)=='R') right--;

        int ans=0;
        int movingR=0;

        for(int i=left; i<=right; i++){
            int c = directions.charAt(i);

            if(c=='R'){
                movingR++;
            }
            else if(c=='S'){
                ans+=movingR;
                movingR=0;
            }
            else{
                ans+=movingR+1;
                movingR=0;
            }
        }
        return ans;
    }
}