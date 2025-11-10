class Solution {
    public int numWays(int steps, int arrLen) {
        int maxPosition = Math.min(steps/2+1, arrLen);
        int[] currWays = new int[maxPosition + 2];
        int[] nextWays = new int[maxPosition + 2];
        currWays[1] = 1;
        int mod = 1000000007;

        while(steps>0) {
            for(int pos = 1; pos <= maxPosition; pos++) {
                nextWays[pos] = (int)(((long)currWays[pos] + currWays[pos-1] + currWays[pos+1]) % mod);
            }

            int[] temp = currWays;
            currWays = nextWays;
            nextWays = temp;
            steps--;
        }
        return currWays[1];
    }
}