class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3)
            return points.length;

        int maxPoints = 2;

        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                int currentPoints = 2;

                for (int k = 0; k < points.length; k++) {
                    if (k == j || k == i)
                        continue;

                    // Cross-multiply slopes to avoid floating-point issues
                    int m1 = (points[j][1] - points[i][1]) * (points[j][0] - points[k][0]);
                    int m2 = (points[j][1] - points[k][1]) * (points[j][0] - points[i][0]);

                    if (m1 == m2)
                        currentPoints++;
                }

                maxPoints = Math.max(maxPoints, currentPoints);
            }
        }

        return maxPoints;
    }
}