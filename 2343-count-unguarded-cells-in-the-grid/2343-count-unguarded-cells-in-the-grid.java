class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for( int[] guard : guards ) {
            grid[guard[0]][guard[1]] = 2;
        }

        for ( int[] wall : walls ) {
            grid[wall[0]][wall[1]] = 2;
        }

        int[] directions = {-1,0,1,0,-1};

        for( int[] guard:guards ) {
            for ( int dirIndex=0; dirIndex < 4; dirIndex++ ) {
                int currentRow = guard[0];
                int currentCol = guard[1];
                int rowDelta = directions[dirIndex];
                int colDelta = directions[dirIndex + 1];

                while ( currentRow + rowDelta >= 0 &&
                        currentRow + rowDelta < m &&
                        currentCol + colDelta >= 0 &&
                        currentCol + colDelta < n &&
                        grid[currentRow + rowDelta][currentCol + colDelta] < 2) {
                            currentRow += rowDelta;
                            currentCol +=colDelta;
                            grid[currentRow][currentCol] = 1;
                        }
            }
        }

        int unguardedCount = 0;
        for(int[] row:grid) {
            for(int cell:row) {
                if(cell == 0){
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }
}