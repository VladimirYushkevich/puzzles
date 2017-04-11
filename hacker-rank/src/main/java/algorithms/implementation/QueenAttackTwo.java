package algorithms.implementation;

import java.util.*;

public class QueenAttackTwo {

    static Map<Double, Integer> allowedPointsToAngle = new HashMap<>(8);
    static List<Double> vectors = Arrays.asList(0.0d, 45.0d, 90.0d, 135.0d, 180.0d, 225.0d, 270.0d, 315.0d);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int yQueen = in.nextInt();
        int xQueen = in.nextInt();
        Point pQueen = new Point(xQueen, yQueen);

        initBoard(pQueen, n);

        for (int a0 = 0; a0 < k; a0++) {
            int yObstacle = in.nextInt();
            int xObstacle = in.nextInt();

            insertObstacle(pQueen, new Point(xObstacle, yObstacle));
        }

        System.out.println(getTotalAllowedPoints());
    }

    static int getTotalAllowedPoints() {
        return allowedPointsToAngle.values().stream().mapToInt(Integer::intValue).sum();
    }

    static void initBoard(Point pQueen, int boardSize) {
        for (Double angle : vectors) {
            allowedPointsToAngle.put(angle, getNumberOfPoints(pQueen, boardSize, angle));
        }
    }

    static void insertObstacle(Point pQueen, Point point) {
        final Double angle = getAngle(pQueen, point);

        final Integer numberOfPoints = allowedPointsToAngle.get(angle);
        if (numberOfPoints != null) {
            final int numberOfPointsBeforeObstacle = getNumberOfPointsBeforeObstacle(pQueen, point);
            if (numberOfPointsBeforeObstacle < numberOfPoints) {
                allowedPointsToAngle.put(angle, numberOfPointsBeforeObstacle);
            }
        }
    }

    static int getNumberOfPointsBeforeObstacle(Point pQueen, Point point) {
        final Double slope = (double) (point.y - pQueen.y) / (point.x - pQueen.x);
        if (Math.abs(slope) == 0.0d) {
            return Math.abs(point.x - pQueen.x) - 1;
        } else if (slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY || Math.abs(slope) == 1.0d) {
            return Math.abs(point.y - pQueen.y) - 1;
        } else {
            return 0;
        }
    }

    static Double getAngle(Point pQueen, Point point) {
        double angle = Math.toDegrees(Math.atan2(point.y - pQueen.y, point.x - pQueen.x));
        if (angle < 0) {
            angle += 360;
        }

        return angle;
    }

    static int getNumberOfPoints(Point pQueen, int boardSize, double angle) {
        final double cos = Math.cos(Math.toRadians(angle));
        final double sin = Math.sin(Math.toRadians(angle));

        double maxX = cos * ((cos > 0 ? boardSize : 1) - pQueen.x) /
                ((angle / 45.0d) % 2 == 0 ? 1.0 : Math.cos(Math.toRadians(45.0d)));
        double maxY = sin * ((sin > 0 ? boardSize : 1) - pQueen.y) /
                ((angle / 45.0d) % 2 == 0 ? 1.0 : Math.sin(Math.toRadians(45.0d)));

        final double positionTryX = Math.abs(cos) > 0 ? pQueen.x + cos : pQueen.x;
        final double positionTryY = Math.abs(sin) > 0 ? pQueen.y + sin : pQueen.y;

        if (positionTryX > boardSize || positionTryY > boardSize ||
                positionTryX < 1 || positionTryY < 1) {
            return 0;
        } else {
            return Double.valueOf((Math.round(maxX) < 1.0d || Math.round(maxY) < 1.0d) ? Math.round(Math.max(maxX, maxY)) :
                    Math.round(Math.min(maxX, maxY))).intValue();
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
