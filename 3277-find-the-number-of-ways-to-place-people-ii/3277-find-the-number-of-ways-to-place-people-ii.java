import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int pairCount = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];   
            int lowerYLimit = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int currentY = points[j][1];

                if (currentY <= upperY && currentY > lowerYLimit) {
                    pairCount++;
                    lowerYLimit = currentY;

                    if (currentY == upperY) break;
                }
            }
        }

        return pairCount;
    }
}
