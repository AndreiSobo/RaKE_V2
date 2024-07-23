package HRI_chatGPT3_5;


import HRI_Claude_3_5_Sonnet.ObjectHRI;
import HRI_Claude_3_5_Sonnet.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotCollisionTest {
    private HRI_Claude_3_5_Sonnet.Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot();
    }

    @Test
    void testMoveToObjectPositionWithOpenGripper() {
        robot.addObject(new HRI_Claude_3_5_Sonnet.ObjectHRI(1, 2, 0));
        assertDoesNotThrow(() -> {
            robot.moveX(1);
        }, "Moving to object position with open gripper should not throw an exception");
    }

    @Test
    void testMoveToObjectPositionWithClosedGripper() {
        robot.addObject(new HRI_Claude_3_5_Sonnet.ObjectHRI(1, 2, 0));
        robot.closeGripper();
        assertThrows(IllegalStateException.class, () -> {
            robot.moveX(1);
        }, "Moving to object position with closed gripper should throw an IllegalStateException");
    }

    @Test
    void testMoveOverObjectWithClosedGripper() {
        robot.addObject(new HRI_Claude_3_5_Sonnet.ObjectHRI(0, 1, 0));
        robot.closeGripper();
        assertThrows(IllegalStateException.class, () -> {
            robot.moveY(-1);
        }, "Moving over object with closed gripper should throw an IllegalStateException");
    }

    @Test
    void testMoveAwayFromObjectWithClosedGripper() {
        robot.addObject(new HRI_Claude_3_5_Sonnet.ObjectHRI(1, 2, 0));
        robot.closeGripper();
        assertDoesNotThrow(() -> {
            robot.moveX(-1);
        }, "Moving away from object with closed gripper should not throw an exception");
    }


    @Test
    void testNoCollisionWhenObjectNotInPath() {
        robot.addObject(new HRI_Claude_3_5_Sonnet.ObjectHRI(2, 2, 2));
        robot.closeGripper();
        assertDoesNotThrow(() -> {
            robot.moveX(1);
            robot.moveY(1);
            robot.moveZ(1);
        }, "No collision should be detected when object is not in path");
    }

    @Test
    void testCollisionWhenMovingDiagonally() {
        robot.addObject(new ObjectHRI(1, 1, 1));
        robot.closeGripper();
        assertThrows(IllegalStateException.class, () -> {
            robot.moveX(1);
            robot.moveY(-1);
            robot.moveZ(1);
        }, "Collision should be detected when moving diagonally to object position");
    }
}