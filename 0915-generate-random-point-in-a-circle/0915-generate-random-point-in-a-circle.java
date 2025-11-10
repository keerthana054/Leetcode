class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.random = new Random();
    }
    
    public double[] randPoint() {
        double randomRadius = Math.sqrt(random.nextDouble() * radius * radius);
        double randomAngle = random.nextDouble() * 2 * Math.PI;


        double x = xCenter + randomRadius * Math.cos(randomAngle);
        double y = yCenter + randomRadius * Math.sin(randomAngle);

        return new double[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */