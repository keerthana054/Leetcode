class Solution {
    public int findDelayedArrivalTime(int aT, int dT) {
        return (aT+dT)%24;
    }
}