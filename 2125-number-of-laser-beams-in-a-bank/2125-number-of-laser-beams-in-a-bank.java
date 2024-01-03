class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, rows = bank.length, cols = bank[0].length(), Cnt = 0;
        for(int r = 0; r < rows; r++){
            int cur = 0;
            for(int c = 0; c < cols; c++){
                cur += bank[r].charAt(c) - '0';   
            }
            Cnt  += cur * prev;
            if(cur > 0)
                prev = cur;
        }
        return Cnt;
    }
}