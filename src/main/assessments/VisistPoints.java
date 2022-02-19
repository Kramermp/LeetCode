package main.assessments;

public class VisistPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length < 1) {
            return 0;
        }

        int totalDistance = 0;
        for(int i = 0; i < points.length - 1; i++) {
            System.out.println("Targeting " + points[i + 1][0] + " " + points[i + 1][1]);
            totalDistance+=calculateDistance(points[i][0], points[i + 1][0], points[i][1], points[i + 1][1]);
        }

        return totalDistance;
    }

    public int calculateDistance (int x1, int x2, int y1, int y2) {
        int xDif = (int)Math.sqrt(Math.pow(x2 - x1, 2));
        int yDif = (int)Math.sqrt(Math.pow(y2 - y1, 2));

        return Math.max(xDif, yDif);
    }

    private int move(int num1, int num2) {
        if(num1 == num2) {
            return num2;
        } else if (num1 > num2) {
            return num1 - 1;
        } else {
            return num1 + 1;
        }
    }

}
