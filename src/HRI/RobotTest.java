package HRI;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void robotMovesCorrectlyOnXAxis() {
        Robot r = new Robot();
        r.moveX(3);
        assertEquals(3.0, r.getX());
    }

    @Test
    public void robotMovesCorrectlyOnYAxis() {
        Robot r = new Robot();
        r.moveY(-4);
        assertEquals(-2.0, r.getY()); // The robot's arm is always 2 cm above the ground level
    }

    @Test
    public void robotMovesCorrectlyOnZAxis() {
        Robot r = new Robot();
        r.moveZ(5);
        assertEquals(5.0, r.getZ());
    }

    @Test
    public void robotMovesCorrectlyOnAllAxes() {
        Robot r = new Robot();
        r.moveX(2);
        r.moveY(3);
        r.moveZ(4);
        assertEquals(2.0, r.getX());
        assertEquals(5.0, r.getY()); // The robot's arm is now 5 cm above the ground level
        assertEquals(4.0, r.getZ());
    }

    @Test
    public void robotStaysInPlaceWhenNotMoved() {
        Robot r = new Robot();
        assertEquals(0.0, r.getX());
        assertEquals(2.0, r.getY()); // The robot's arm is always 2 cm above the ground level
        assertEquals(0.0, r.getZ());
    }

    @Test
    public void robotMovesBackToOrigin() {
        Robot r = new Robot(2, 3, 4);
        r.moveX(-2);
        r.moveY(-1);
        r.moveZ(-4);
        assertEquals(0.0, r.getX());
        assertEquals(2.0, r.getY()); // The robot's arm is always 2 cm above the ground level
        assertEquals(0.0, r.getZ());
    }
    // tests for LLM after v5 system prompt.
    @Test
    public void robotPicksUpObjectAt4_0_3FromNonOrigin() {
        Robot r = new Robot(1, 2, 1);
        r.pickUpObject4_0_3();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    @Test
    public void pickUpObject3_0_9Remain() {
        Robot r = new Robot();
        r.pickUpObject3_0_9Remain();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(3.0, 2.0, 9.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    @Test
    public void robotMovesObjectLeft4Then2FromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.moveObjectLeft4Then2();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }
}