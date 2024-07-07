package HRI;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    // tests for LLM after system prompt.

    // "pickup object at 4,0,3"
    @Test
    public void robotPicksUpObjectAt4_0_3FromNonOrigin() {
        Robot r = new Robot(5, 2, 1);
        r.pickUpObjectAt4_0_3();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(4.0, 2.0, 3.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "pickup object at 3,0,9 and return to origin"
    @Test
    public void robotPicksUpObjectAt3_0_9AndReturnsFromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.pickUpObjectAt3_0_9AndReturn();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "move the object that is 4 cm to the left from origin, another 2 cm to the left and place it on the ground"
    @Test
    public void robotMovesObjectLeftAndPlacesFromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.moveObjectLeftAndPlace();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-6.0, 0.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "move the object from 5,0,1 to 3,2,1. do not return to origin"
    @Test
    public void robotMovesObjectFrom5_0_1To3_2_1FromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.moveObjectFrom5_0_1To3_2_1();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(3.0, 2.0, 1.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    @Test
    public void robotPicksUpObjectLeftAndForwardFromOrigin() {
        Robot r = new Robot();
        r.pickUpObjectLeftAndForward();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-7.0, 2.0, 4.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "pickup the object situated 2 cm to the right from origin"
    @Test
    public void robotPicksUpObjectRightFromNonOrigin() {
        Robot r = new Robot(1, 2, 1);
        r.pickUpObjectRight();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(2.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "place the object at 4,0,1 two cm forward on the ground"
    @Test
    public void robotPlacesObjectAt4_0_1TwoCmForwardFromNonOrigin() {
        Robot r = new Robot(1, 2, 3);
        r.placeObjectAt4_0_1TwoCmForward();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(4.0, 0.0, 3.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "move the arm 2 cm to the left from origin. pickup the object situated on the ground 3 cm to the right from  your position and place it at position 5,0,5. do not return to origin"
    @Test
    public void robotPicksUpAndPlacesObjectFromNegativeX() {
        Robot r = new Robot(-2, 3, 4);
        r.pickUpAndPlaceObject();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(5.0, 2.0, 5.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "take the object situated 4 cm to the left and move it 5 cm to the right. Do not return to origin"
    @Test
    public void robotMovesObjectRightFromOrigin() {
        Robot r = new Robot();
        r.moveObjectRight();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(1.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "move the object situated 2 cm to the left from origin to origin"
    @Test
    public void robotMovesObjectToOriginFromNegativeX() {
        Robot r = new Robot(-2, 2, 1);
        r.moveObjectToOrigin();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "place the object from -3,0,3 forward 2 cm on the ground then return to origin"
    @Test
    public void robotPlacesObjectForwardAndReturnsFromNonOrigin() {
        Robot r = new Robot(1, 2, 1);
        r.placeObjectForwardAndReturn();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Pickup last object placed and place it on the ground 2 cm to the left. do not return to origin"
    @Test
    public void robotPicksUpAndPlacesObjectLeftFromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.pickUpAndPlaceLeft();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-5.0, 0.0, 5.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "place the object situated at 2,1,2 on the ground 4 cm to the left"
    @Test
    public void robotPlacesObjectLeftFromNegativeX() {
        Robot r = new Robot(-1, 2, 1);
        r.placeObjectLeft();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-2.0, 0.0, 2.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Take the object at 1,0,1 and place it at 2,0,1. Then take another object at 3,0,3 and place it one cm to the right"
    @Test
    public void robotMovesTwoObjectsFromOrigin() {
        Robot r = new Robot();
        r.moveTwoObjects();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(4.0, 0.0, 3.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Take one object situated at 4,0,2 and place it on top of the object situated at cords -2,0,3"
    @Test
    public void robotPlacesObjectOnTopFromNegativeX() {
        Robot r = new Robot(-4, 2, 1);
        r.placeObjectOnTop();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-2.0, 2.0, 3.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Move an object from -2,0,2 at coordinates 3,0,2. Then pick it up and move it 2 cm to the left"
    @Test
    public void robotMovesObjectAndPicksUpFromOrigin() {
        Robot r = new Robot();
        r.moveObjectAndPickUp();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(1.0, 0.0, 2.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Pickup the object 4 cm to the left and drop it from 1 cm height to the coordinates 4,3,2"
    @Test
    public void robotPicksUpAndDropsObjectFromOrigin() {
        Robot r = new Robot();
        r.pickUpAndDrop();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(4.0, 4.0, 2.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "From origin, draw a square in the air with a side length of 3."
    @Test
    public void robotDrawsSquareInAirFromOrigin() {
        Robot r = new Robot();
        r.drawSquareInAir();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 2.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "There are 3 objects. First is at coordinates 3,0,1, second is at 4,0,2 and third at -2,0,2. I want you to pick them
    // and place them on top of each other at coordinates -5,0,5. The gripper can only hold one object at a time."
    @Test
    public void robotStacksObjectsCorrectly() {
        Robot r = new Robot();
        r.stackObjects();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(-5.0, 3.0, 5.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "There are 2 objects are coordinates 3,0,2 and -3,0,2. Can you swap them around."
    @Test
    public void robotSwapsObjectsCorrectlyFromOrigin() {
        Robot r = new Robot();
        r.swapObjects();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(3.0, 2.0, 2.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Pickup the object at 2,0,2 and throw it forward"
    @Test
    public void robotThrowsObjectFromOrigin() {
        Robot r = new Robot();
        r.throwObject();
        ArrayList<Double> expectedPosition = new ArrayList<>(Arrays.asList(2.0, 2.0, 4.0));
        assertEquals(expectedPosition, r.getPosition());
    }

    // "Pickup the last two objects moved and place them next to each other at coords -5,0,7"
    // Test class purposely failed as the method implementation had clear logical errors.
    @Test
    public void placeObjectsSideBySideTest() {
        Robot r = new Robot();
        r.placeObjectsSideBySide();
        ArrayList <Double> expectedPosition = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        assertEquals(expectedPosition, r.getPosition());
    }

}