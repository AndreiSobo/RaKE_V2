package HRI_chatGPT3_5;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;


public class RobotTest {

    @Test
    public void testPickupObjectAt3_0_9() {
        Robot r = new Robot(0, 2, 0);
        r.pickUpObjectAt3_0_9DoNotReturn();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(3, 2, 9));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(3, 2, 9);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(3, 2, 9));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupObjectLeftAndForward() {
        Robot r = new Robot(0, 2, 0);
        r.pickUpObject7CmLeftAnd4CmForward();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(0, 2, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupAndMoveObject() {
        Robot r = new Robot(0, 2, 0);
        r.pickUpObjectAndMoveToMinus2_0_2();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 0, 2));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveAndPlaceObjectForward() {
        Robot r = new Robot(0, 2, 0);
        r.placeObjectAt4_0_1TwoCmForward();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(4, 0, 3);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 0, 3));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }
    @Test
    public void testComplexMovePickupAndPlace() {
        Robot r = new Robot(0, 2, 0);
        r.moveLeftPickUpAndPlaceObject();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(5, 2, 5));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(5, 0, 5);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(5, 0, 5));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupLeftPlaceRight() {
        Robot r = new Robot(0, 2, 0);
        r.pickUpAndPlaceObject();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(3, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(3, 0, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testPickupLastObjectMoveLeft() {
        Robot r = new Robot(0, 2, 0);
        r.pickUpLastObjectAndPlaceLeft();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(1, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 0));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveObjectLeftAndPlace() {
        Robot r = new Robot(0, 2, 0);
        r.placeObjectLeft();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(-2, 2, 2));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 0, 2));
        assertEquals(objectExpectedPosition, o1.getPosition());
    }

    @Test
    public void testMoveTwoObjectsSequence() {
        Robot r = new Robot(0, 2, 0);
        r.moveTwoObjects();
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
        r.placeObjectOnTop();
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
        r.moveObjectAndMoveLeft();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(1, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testPickupLeftPlaceAtCoordinates() {
        Robot r = new Robot(0, 2, 0);
        r.pickupObjectAndPlaceAt4_3_2();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(4, 0, 2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 3, 2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testDrawSquareInAir() {
        Robot r = new Robot(0, 2, 0);
        r.drawSquareInAir();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
    }

    @Test
    public void testStackThreeObjects() {
        Robot r = new Robot(0, 2, 0);
        r.stackObjectsAt_neg5_0_5();
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
        r.swapObjects_3_0_2_neg3_0_2();
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
        r.pickupAndStackLastTwoObjects();
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
        r.moveAndPlaceObjects();
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
        r.pickupAndMoveObjectToNewZ();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(1, 0, 5);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(1, 0, 5));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testMoveObjectToNewXPosition() {
        Robot r = new Robot(0, 2, 0);
        r.pickupAndMoveObjectToNewX();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(4, 0, 0);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(4, 0, 0));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }

    @Test
    public void testMoveObjectToNew3DPosition() {
        Robot r = new Robot(0, 2, 0);
        r.pickupAndMoveObjectToNewY();
        ArrayList<Integer> robotExpectedPosition = new ArrayList<>(Arrays.asList(0, 2, 0));
        assertEquals(robotExpectedPosition, r.getPosition());
        ObjectHRI obj = new ObjectHRI(-2, 1, -2);
        ArrayList<Integer> objectExpectedPosition = new ArrayList<>(Arrays.asList(-2, 1, -2));
        assertEquals(objectExpectedPosition, obj.getPosition());
    }



}