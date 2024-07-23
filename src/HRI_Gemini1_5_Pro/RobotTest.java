package HRI_Gemini1_5_Pro;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RobotTest {
    @Test
    public void testPickupObjectAt3_0_9() {
        Robot r = new Robot(0, 2, 0);
        r.pickupObjectAt3_0_9NoReturn();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(3, 2, 9));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(3, 2, 9);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(3, 2, 9));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupObjectLeftAndForward() {
        Robot r = new Robot(0, 2, 0);
        r.pickupObjectLeftAndForwardOfOrigin();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(0, 2, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupAndMoveObject() {
        Robot r = new Robot(0, 2, 0);
        r.pickupAndMoveObjectToMinus2_0_2();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 0, 2));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveAndPlaceObjectForward() {
        Robot r = new Robot(0, 2, 0);
        r.placeObjectForward();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(4, 2, 3);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 0, 3));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testComplexMovePickupAndPlace() {
        Robot r = new Robot(0, 2, 0);
        r.moveLeftPickupAndPlaceNoReturn();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(5, 2, 5));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(5, 0, 5);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(5, 0, 5));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupLeftPlaceRight() {
        Robot r = new Robot(0, 2, 0);
        r.pickupLeftAndPlaceRight();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(3, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(3, 0, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupLastObjectMoveLeft() {
        Robot r = new Robot(0, 2, 0);
        r.pickupLastObjectAndPlaceLeftNoLift();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(1, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveObjectLeftAndPlace() {
        Robot r = new Robot(0, 2, 0);
        r.placeObjectLeftNoReturn();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(-2, 2, 2));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 0, 2));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveTwoObjectsSequence() {
        Robot r = new Robot(0, 2, 0);
        r.moveTwoObjectsSequentially();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(2, 0, 1);
        ObjectHRI o2 = new ObjectHRI(4, 0, 3);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(2, 0, 1));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(4, 0, 3));
        assertEquals(object1ExpectedPosition, o1.getPosition());
        assertEquals(object2ExpectedPosition, o2.getPosition());
    }

    @Test
    public void testStackObjects() {
        Robot r = new Robot(0, 2, 0);
        r.stackObjects();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(-2, 1, 3);
        ObjectHRI o2 = new ObjectHRI(-2, 0, 3);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(-2, 1, 3));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(-2, 0, 3));
        assertEquals(object1ExpectedPosition, o1.getPosition());
        assertEquals(object2ExpectedPosition, o2.getPosition());
    }

    @Test
    public void testPickupMoveTwice() {
        Robot r = new Robot(0, 2, 0);
        r.pickupMovePickupMoveLeft();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(1, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testPickupLeftPlaceAtCoordinates() {
        Robot r = new Robot(0, 2, 0);
        r.pickupLeftPlaceAt4_3_2();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(4, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 3, 2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testDrawSquareInAir() {
        Robot r = new Robot(0, 0, 0);
        r.drawSquare();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
    }

    @Test
    public void testStackThreeObjects() {
        Robot r = new Robot(0, 2, 0);
        r.stackThreeObjects();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj1 = new ObjectHRI(-5, 0, 5);
        ObjectHRI obj2 = new ObjectHRI(-5, 1, 5);
        ObjectHRI obj3 = new ObjectHRI(-5, 2, 5);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(-5, 0, 5));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(-5, 1, 5));
        ArrayList<Integer> object3ExpectedPosition = new ArrayList<>(Arrays.asList(-5, 2, 5));
        assertEquals(object1ExpectedPosition, obj1.getPosition());
        assertEquals(object2ExpectedPosition, obj2.getPosition());
        assertEquals(object3ExpectedPosition, obj3.getPosition());
    }

    @Test
    public void testSwapTwoObjects() {
        Robot r = new Robot(0, 2, 0);
        r.swapObjects();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj1 = new ObjectHRI(-3, 0, 2);
        ObjectHRI obj2 = new ObjectHRI(3, 0, 2);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(-3, 0, 2));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(3, 0, 2));
        assertEquals(object1ExpectedPosition, obj1.getPosition());
        assertEquals(object2ExpectedPosition, obj2.getPosition());
    }

    @Test
    public void testStackLastTwoObjects() {
        Robot r = new Robot(0, 2, 0);
        r.stackLastTwoObjects();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj1 = new ObjectHRI(-5, 0, 7);
        ObjectHRI obj2 = new ObjectHRI(-5, 1, 7);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(-5, 0, 7));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(-5, 1, 7));
        assertEquals(object1ExpectedPosition, obj1.getPosition());
        assertEquals(object2ExpectedPosition, obj2.getPosition());
    }

    @Test
    public void testMoveTwoObjectsToNewPositions() {
        Robot r = new Robot(0, 2, 0);
        r.moveTwoObjectsToNewPositions();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj1 = new ObjectHRI(5, 0, 5);
        ObjectHRI obj2 = new ObjectHRI(6, 0, 5);
        ArrayList<Integer> object1ExpectedPosition = new ArrayList<>(Arrays.asList(5, 0, 5));
        ArrayList<Integer> object2ExpectedPosition = new ArrayList<>(Arrays.asList(6, 0, 5));
        assertEquals(object1ExpectedPosition, obj1.getPosition());
        assertEquals(object2ExpectedPosition, obj2.getPosition());
    }

    @Test
    public void testMoveObjectAlongZAxis() {
        Robot r = new Robot(0, 2, 0);
        r.moveObjectToNewZPosition();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(1, 0, 5);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 5));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testMoveObjectToNewXPosition() {
        Robot r = new Robot(0, 2, 0);
        r.moveObjectToNewXPosition();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(4, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 0, 0));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testMoveObjectToNew3DPosition() {
        Robot r = new Robot(0, 2, 0);
        r.moveObjectToNewYPosition();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(-2, 1, -2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 1, -2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }
}
