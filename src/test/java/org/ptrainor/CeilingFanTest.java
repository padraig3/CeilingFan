package org.ptrainor;

import junit.framework.TestCase;

public class CeilingFanTest extends TestCase {

    /**
     * Checks expected vs actual direction, speed and direction * speed. Invoking tests will fail on
     * any failed assert statements.
     *
     * @param fan the CeilingFan instance
     * @param expectedDirection expected direction
     * @param expectedSpeed expected speed
     */
    private void validate(final CeilingFan fan, final int expectedDirection, final int expectedSpeed) {
        assertEquals(expectedDirection, fan.getDirection());
        assertEquals(expectedSpeed, fan.getSpeed());
        assertEquals(expectedDirection * expectedSpeed, fan.getSpeedDirection());
    }

    /**
     * Tests that initially created fan has expected speed and direction
     */
    public void testInitial() {
        final int expectedDirection = CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = CeilingFan.INITIAL_SPEED;
        CeilingFan fan = new CeilingFan();
        validate(fan, expectedDirection, expectedSpeed);
    }

    /**
     * Tests expectations when speed cord pulled once
     */
    public void testPullSpeed() {
        final int expectedDirection = CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = (CeilingFan.INITIAL_SPEED + 1) % (CeilingFan.NUM_SPEEDS + 1);
        CeilingFan fan = new CeilingFan();
        fan.pullSpeedCord();
        validate(fan, expectedDirection, expectedSpeed);
    }

    /**
     * Tests expectations when reverse cord pulled once
     */
    public void testPullReverse() {
        final int expectedDirection = -CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = CeilingFan.INITIAL_SPEED;
        CeilingFan fan = new CeilingFan();
        fan.pullReverseCord();
        validate(fan, expectedDirection, expectedSpeed);
    }

    /**
     * Tests expectations when speed cord pulled once and reverse cord pulled once
     */
    public void testPullSpeedReverse() {
        final int expectedDirection = -CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = (CeilingFan.INITIAL_SPEED + 1) % (CeilingFan.NUM_SPEEDS + 1);
        CeilingFan fan = new CeilingFan();
        fan.pullSpeedCord();
        fan.pullReverseCord();
        validate(fan, expectedDirection, expectedSpeed);
    }

    /**
     * Tests expectations when speed cord pulled twice
     */
    public void testPullSpeed2() {
        final int expectedDirection = CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = (CeilingFan.INITIAL_SPEED + 2) % (CeilingFan.NUM_SPEEDS + 1);
        CeilingFan fan = new CeilingFan();
        for (int i = 0; i < 2; i++) {
            fan.pullSpeedCord();
        }
        validate(fan, expectedDirection, expectedSpeed);
    }

    /**
     * Tests expectations when speed cord pulled 4x
     */
    public void testPullSpeed4() {
        final int expectedDirection = CeilingFan.INITIAL_DIRECTION;
        final int expectedSpeed = (CeilingFan.INITIAL_SPEED + 4) % (CeilingFan.NUM_SPEEDS + 1);
        CeilingFan fan = new CeilingFan();
        for (int i = 0; i < 4; i++) {
            fan.pullSpeedCord();
        }
        validate(fan, expectedDirection, expectedSpeed);
    }
}