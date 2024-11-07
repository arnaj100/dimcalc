package edu.up.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }


    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);

    }

    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        assertTrue(testPoints.getPoint(0).x <= 10);
        assertTrue(testPoints.getPoint(0).x >= -10);
        assertTrue(testPoints.getPoint(0).y <= 10);
        assertTrue(testPoints.getPoint(0).y >= 10);
        /**
         *      TwoPoints testPoints = new TwoPoints();
         *      testPoints.randomValue(0);
         *      int x = testPoints.getPoint(0).x;
         *      int y = testPoints.getPoint(0).y;
         *      testPoints.randomValue(0);
         *      assertTrue(x != testPoints.getPoint(0).x);
         *      assertTrue(y != testPoints.getPoint(0).y);
         */
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        Point p1 = testPoints.getPoint(0);
        testPoints.setOrigin(0);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
    }

    @Test
    public void copy() {
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 0);
        testPoints.setPoint(1, -3, 0);
        double calcDistance = testPoints.distance();
        double expectedDistance = 8.0;
        assertEquals(calcDistance, expectedDistance, 0.05);

        testPoints.setPoint(0, 0, 5);
        testPoints.setPoint(1, 0, -3);
        calcDistance = testPoints.distance();
        expectedDistance = 8.0;
        assertEquals(calcDistance, expectedDistance, 0.05);

        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1, 2, 2);
        calcDistance = testPoints.distance();
        expectedDistance = 2.8;
        assertEquals(calcDistance, expectedDistance, 0.05);

    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 1, 1);
        assertTrue(0.0 == testPoints.slope());

        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 1, 3);
        boolean divByZero = false;
        try {
            testPoints.slope();
        }
        catch (ArithmeticException e) {
            divByZero = true;
        }
        assertTrue(divByZero);

        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 3, 1);
        assertTrue(0.0 == testPoints.slope());

        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 3, 5);
        assertTrue(2.0 == testPoints.slope());


    }
}