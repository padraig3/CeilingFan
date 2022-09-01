package org.ptrainor;

public class CeilingFan {

    // number of speed settings apart from the 'off' setting. must be > 0
    public final static int NUM_SPEEDS = 3;
    // speed of fan when initially instantiated. must be in range 0..NUM_SPEEDS
    public final static int INITIAL_SPEED = 0;
    // direction of fan when initially instantiated. must be either -1 or +1
    public final static int INITIAL_DIRECTION = 1;

    /*
     * speed of fan is integer in inclusive range 0..NUM_SPEEDS
     * where 0 = at rest / no speed
     * non-zero values are speeds proportional to integer value.
     * NUM_SPEEDS value is fastest, NUM_SPEEDS - 1 slower than NUM_SPEEDS, etc
     */
    private int speed;
    /*
     * direction of fan: +1 = forward, -1 = backwards
     */
    private int direction;

    public CeilingFan() {
        if (NUM_SPEEDS <= 0) {
            throw new RuntimeException("Class attribute NUM_SPEEDS must be greater than zero.");
        }
        if (INITIAL_SPEED < 0 || INITIAL_SPEED > NUM_SPEEDS) {
            throw new RuntimeException("Class attribute INITIAL_SPEED must not be negative and <= NUM_SPEEDS.");
        }
        speed = INITIAL_SPEED;

        if (INITIAL_DIRECTION != -1 && INITIAL_DIRECTION != 1) {
            throw new RuntimeException("Class attribute INITIAL_DIRECTION must be either 1 or -1.");
        }
        direction = INITIAL_DIRECTION;
    }

    /**
     * Increments the fan speed. If speed is currently at max speed will set the speed to zero
     */
    public void pullSpeedCord() {
        speed++;
        // this modulus operation will set speed to zero if was at maximum speed before increment
        speed = speed % (NUM_SPEEDS + 1);
        // FYI could implement this method with one line "++speed % (NUM_SPEEDS + 1)"
        // but is less readable / intuitive IMO
    }

    /**
     * Reverses the fan direction
     */
    public void pullReverseCord() {
        direction *= -1;
    }

    /**
     * @return non-negative integer where 0 means no speed and non-zero values
     * indicate speeds proportional to their value.
     * For example 3 is faster than 2, 2 is faster than 1
     */
    public final int getSpeed() {
        return speed;
    }

    /**
     * @return integer either -1 or +1 where:
     * +1 - forward direction
     * -1 - reverse direction
     */
    public final int getDirection() {
        return direction;
    }

    /**
     * @return integer in range -NUM_SPEEDS,.. -1, 0, +1, ..NUM_SPEEDS where:
     * 0 - no direction or speed / fan at rest
     * positive values - speed values where fan is moving in forward direction
     * negative values - speed values where fan is moving in reverse direction
     *
     * As described above, speeds are proportional to their absolute value. For example,
     * abs(-3) is faster than 2, 2 is faster than abs(-1)
     */
    public final int getSpeedDirection() {
        return speed * direction;
    }
}
