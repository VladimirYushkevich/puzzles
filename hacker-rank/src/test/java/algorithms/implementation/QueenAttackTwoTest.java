package algorithms.implementation;

import org.junit.Before;
import org.junit.Test;

import static algorithms.implementation.QueenAttackTwo.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class QueenAttackTwoTest {

    private QueenAttackTwo.Point pQueen;
    private int boardSize;

    @Before
    public void setUp() throws Exception {
        pQueen = new QueenAttackTwo.Point(3, 4);
        boardSize = 5;
        initBoard(pQueen, boardSize);
    }

    @Test
    public void testInsertObstacles() throws Exception {
        insertObstacle(pQueen, new QueenAttackTwo.Point(5, 5));
        insertObstacle(pQueen, new QueenAttackTwo.Point(2, 4));
        insertObstacle(pQueen, new QueenAttackTwo.Point(3, 2));

        assertThat(getTotalAllowedPoints(), is(10));

        allowedPointsToAngle.clear();
        initBoard(new Point(4, 4), 4);

        assertThat(getTotalAllowedPoints(), is(9));

        allowedPointsToAngle.clear();
        initBoard(new Point(1, 1), 8);

        assertThat(getTotalAllowedPoints(), is(21));
    }

    @Test
    public void testInitBoard() throws Exception {
        assertThat(allowedPointsToAngle.get(0.0d), is(2));
        assertThat(allowedPointsToAngle.get(45.0d), is(1));
        assertThat(allowedPointsToAngle.get(90.0d), is(1));
        assertThat(allowedPointsToAngle.get(135.0d), is(1));
        assertThat(allowedPointsToAngle.get(180.0d), is(2));
        assertThat(allowedPointsToAngle.get(225.0d), is(2));
        assertThat(allowedPointsToAngle.get(270.0d), is(3));
        assertThat(allowedPointsToAngle.get(315.0d), is(2));

        assertNull(allowedPointsToAngle.get(314.0d));
    }

    @Test
    public void testGetNumberOfPointsBeforeObstacle() throws Exception {
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(5, 4)), is(1));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(2, 4)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(4, 5)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(2, 3)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(2, 5)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(4, 3)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(3, 5)), is(0));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(3, 2)), is(1));
        assertThat(getNumberOfPointsBeforeObstacle(pQueen, new QueenAttackTwo.Point(5, 5)), is(0));
    }

    @Test
    public void testGetAngle() throws Exception {
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(4, 4)), is(0.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(5, 4)), is(0.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(4, 5)), is(45.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(3, 5)), is(90.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(2, 5)), is(135.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(2, 4)), is(180.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(2, 3)), is(225.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(3, 3)), is(270.0d));
        assertThat(getAngle(pQueen, new QueenAttackTwo.Point(4, 3)), is(315.0d));
    }

    @Test
    public void testGetNumberOfPoints() throws Exception {
        assertThat(getNumberOfPoints(pQueen, boardSize, 0.0d), is(2));
        assertThat(getNumberOfPoints(pQueen, boardSize, 45.0d), is(1));
        assertThat(getNumberOfPoints(pQueen, boardSize, 90.0d), is(1));
        assertThat(getNumberOfPoints(pQueen, boardSize, 135.0d), is(1));
        assertThat(getNumberOfPoints(pQueen, boardSize, 180.0d), is(2));
        assertThat(getNumberOfPoints(pQueen, boardSize, 225.0d), is(2));
        assertThat(getNumberOfPoints(pQueen, boardSize, 270.0d), is(3));
        assertThat(getNumberOfPoints(pQueen, boardSize, 315.0d), is(2));

        final Point point1 = new Point(4, 5);
        assertThat(getNumberOfPoints(point1, boardSize, 0.0d), is(1));
        assertThat(getNumberOfPoints(point1, boardSize, 45.0d), is(0));
        assertThat(getNumberOfPoints(point1, boardSize, 90.0d), is(0));
        assertThat(getNumberOfPoints(point1, boardSize, 135.0d), is(0));
        assertThat(getNumberOfPoints(point1, boardSize, 180.0d), is(3));
        assertThat(getNumberOfPoints(point1, boardSize, 225.0d), is(3));
        assertThat(getNumberOfPoints(point1, boardSize, 270.0d), is(4));
        assertThat(getNumberOfPoints(point1, boardSize, 315.0d), is(1));

        final Point point2 = new Point(5, 5);
        assertThat(getNumberOfPoints(point2, boardSize, 0.0d), is(0));
        assertThat(getNumberOfPoints(point2, boardSize, 45.0d), is(0));
        assertThat(getNumberOfPoints(point2, boardSize, 90.0d), is(0));
        assertThat(getNumberOfPoints(point2, boardSize, 135.0d), is(0));
        assertThat(getNumberOfPoints(point2, boardSize, 180.0d), is(4));
        assertThat(getNumberOfPoints(point2, boardSize, 225.0d), is(4));
        assertThat(getNumberOfPoints(point2, boardSize, 270.0d), is(4));
        assertThat(getNumberOfPoints(point2, boardSize, 315.0d), is(0));

        final Point point3 = new Point(1, 1);
        assertThat(getNumberOfPoints(point3, 1, 0.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 45.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 90.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 135.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 180.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 225.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 270.0d), is(0));
        assertThat(getNumberOfPoints(point3, 1, 315.0d), is(0));
    }

    @Test
    public void testInsertObstacle() throws Exception {
        insertObstacle(pQueen, new QueenAttackTwo.Point(2, 4));
    }

    @Test
    public void testMath() throws Exception {
        assertThat(-0.0d * 1.0d, is(-0.0d));
        assertThat(-0.0d * Double.POSITIVE_INFINITY, is(Double.NaN));
        assertThat(-0.0d * Double.NEGATIVE_INFINITY, is(Double.NaN));

        assertThat(Math.toDegrees(Math.atan2(4 - 4, 4 - 3)), is(0.0d));
        assertThat(Math.toDegrees(Math.atan2(5 - 4, 4 - 3)), is(45.0d));
        assertThat(Math.toDegrees(Math.atan2(5 - 4, 3 - 3)), is(90.0d));
        assertThat(Math.toDegrees(Math.atan2(5 - 4, 2 - 3)), is(135.0d));
        assertThat(Math.toDegrees(Math.atan2(4 - 4, 2 - 3)), is(180.0d));
    }
}
