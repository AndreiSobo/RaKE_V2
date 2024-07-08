package HRI;

import java.util.ArrayList;

public class Robot_Claude3_5Sonnet {
    public double x;
    public double y;
    public double z;
    public ArrayList<Double> coords = new ArrayList<>();

    // Constructor to initialize the robot's position at coordinates (x, y)
    public Robot_Claude3_5Sonnet() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
    }

    public Robot_Claude3_5Sonnet(double X, double Y, double Z) {
        this.x = X;
        this.y = Y;
        this.z = Z;
    }

    // getters of x,y,z
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    // Method to move the robot on the X axis
    public void moveX(double distance) {
//        double oldX = this.x;
        this.x += distance;
//        double newX = this.x;
        System.out.println("Robot moved on x axis by " + distance + " units. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    //    implementing the Y axis
    public void moveY(double distance) {
        this.y += distance;
        System.out.println("Robot moved on y axis by " + distance + " units. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    //    implementing the Z axis
    public void moveZ(double distance) {
        this.z += distance;
        System.out.println("Robot moved on z axis by " + distance + " units. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    public ArrayList<Double> getPosition() {
        coords.add(getX());
        coords.add(getY());
        coords.add(getZ());
        System.out.println("Position: (" + this.x + ", " + this.y + ", " + this.z + ")");
        return coords;
    }

    // method called when the robot is asked to do something outside its abilities.
    public void outOfScope() {
        System.out.println("That instruction is outside the scope of my abilities.");
    }

    public void returnToOrigin() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
        System.out.println("Returning to origin position. Coordinates are: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    // methods for gripper
    public void openGripper() {
        System.out.println("Opening gripper");
    }

    public void closeGripper() {
        System.out.println("Closing gripper");
    }

    // Adding functions from the Claude 3.5 Sonnet LLM here

    // "pickup object at 4,0,3"
    public void pickUpObjectAt4_0_3() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(4); // Move 4 units to the right
        this.moveZ(3); // Move 3 units forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level (y=0)
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to default height
    }
    // Passed

    // "pickup object at 3,0,9 and return to origin"
    public void pickUpObjectAt3_0_9AndReturn() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(3); // Move 3 units to the right
        this.moveZ(9); // Move 9 units forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level (y=0)
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to default height
        this.returnToOrigin(); // Return to the origin with the object
    }
    // Passed

    // "move the object that is 4 cm to the left from origin, another 2 cm to the left and place it on the ground"
    public void moveObjectLeftAndPlace() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-4); // Move 4 cm to the left to reach the object
        this.openGripper(); // Open gripper before lowering the arm
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back up
        this.moveX(-2); // Move an additional 2 cm to the left
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default position
    }
    // Passed

    // "move the object from 5,0,1 to 3,2,1. do not return to origin"
    public void moveObjectFrom5_0_1To3_2_1() {
        this.returnToOrigin(); // Start from a known position
        this.moveX(5); // Move to x=5
        this.moveZ(1); // Move to z=1
        this.openGripper(); // Open gripper before lowering the arm
        this.moveY(-2); // Lower arm to ground level (y=0)
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object
        this.moveX(-2); // Move to x=3
        this.moveY(2); // Move up to y=2
        this.openGripper(); // Release the object
        this.moveY(-2); // Lower the arm back to default position (y=2)
    }
    // Partial. Although the final coordinates are indeed 3,2,1, the order of movements is suboptimal.

    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    public void pickUpObjectLeftAndForward() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(4);  // Move 4 cm forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
    }
    // Passed

    // "pickup the object situated 2 cm to the right from origin"
    public void pickUpObjectRight() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(2); // Move 2 cm to the right
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
    }
    // Passed

    // "place the object situated at 4,0,1 two cm forward on the ground"
    public void placeObjectForwardOnGround() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(1); // Move 1 cm forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveZ(2); // Move 2 cm forward
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "move the arm 2 cm to the left from origin. pickup the object situated on the ground 3 cm to the right from  your position and place it at position 5,0,5. do not return to origin"
    public void pickUpAndPlaceObject() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-2); // Move 2 cm to the left from origin
        this.moveX(3); // Move 3 cm to the right from current position
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(4); // Move to x=5 (current x is 1, so move 4 more)
        this.moveZ(5); // Move to z=5
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "take the object situated 4 cm to the left and move it 5 cm to the right. Do not return to origin"
    public void moveObjectRight() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-4); // Move 4 cm to the left
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(5); // Move 5 cm to the right
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "move the object situated 2 cm to the left from origin to origin"
    public void moveObjectToOrigin() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-2); // Move 2 cm to the left
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(2); // Move 2 cm to the right (back to origin)
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "place the object from -3,0,3 forward 2 cm on the ground then return to origin"
    public void placeObjectForwardAndReturn() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-3); // Move 3 cm to the left
        this.moveZ(3); // Move 3 cm forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveZ(2); // Move forward 2 cm
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
        this.returnToOrigin(); // Return to the origin
    }

    // Passed

    // "Pickup last object placed and place it on the ground 2 cm to the left. do not return to origin"
    public void pickUpAndPlaceLeft() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(-3); // Move to x=-3
        this.moveZ(5); // Move to z=5
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(-2); // Move 2 cm to the left
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "place the object situated at 2,1,2 on the ground 4 cm to the left"
    public void placeObjectLeft() {
        this.returnToOrigin(); // Start at the origin
        this.moveX(2); // Move to x=2
        this.moveY(-1); // Move down to y=1
        this.moveZ(2); // Move to z=2
        this.openGripper(); // Open the gripper before grasping the object
        this.moveY(-1); // Lower arm to reach the object at y=1
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height (y=2)
        this.moveX(-6); // Move 6 cm to the left (4 cm left of the original x position)
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Failed. Incorrect Y coordinates.

    // "Take the object at 1,0,1 and place it at 2,0,1. Then take another object at 3,0,3 and place it one cm to the right"
    public void moveTwoObjects() {
        // First task: Move object from (1,0,1) to (2,0,1)
        this.returnToOrigin(); // Start at the origin
        this.moveX(1); // Move to x=1
        this.moveZ(1); // Move to z=1
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(1); // Move 1 cm to the right to x=2
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height

        // Second task: Move object from (3,0,3) to (4,0,3)
        this.moveX(1); // Move to x=3
        this.moveZ(2); // Move to z=3
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(1); // Move 1 cm to the right to x=4
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "Take one object situated at 4,0,2 and place it on top of the object situated at cords -2,0,3"
    public void placeObjectOnTop() {
        this.returnToOrigin(); // Start at the origin

        // Pick up the object at (4,0,2)
        this.moveX(4); // Move to x=4
        this.moveZ(2); // Move to z=2
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height

        // Move to the position above the second object at (-2,0,3)
        this.moveX(-6); // Move 6 units left to x=-2
        this.moveZ(1); // Move 1 unit forward to z=3

        // Place the object on top of the other object
        this.moveY(-1); // Lower the object 1 unit (assuming objects are 1 unit tall)
        this.openGripper(); // Release the object
        this.moveY(1); // Raise the arm back to the default height
    }
    // Passed

    // "Move an object from -2,0,2 at coordinates 3,0,2. Then pick it up and move it 2 cm to the left"
    public void moveObjectAndPickUp() {
        this.returnToOrigin(); // Start at the origin

        // First move: from (-2,0,2) to (3,0,2)
        this.moveX(-2); // Move to x=-2
        this.moveZ(2); // Move to z=2
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(5); // Move 5 units right to x=3
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height

        // Second move: pick up from (3,0,2) and move 2 cm to the left
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height
        this.moveX(-2); // Move 2 units left
        this.moveY(-2); // Lower the object to the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to the default height
    }
    // Passed

    // "Pickup the object 4 cm to the left and drop it from 1 cm height to the coordinates 4,3,2"
    public void pickUpAndDrop() {
        this.returnToOrigin(); // Start at the origin

        // Pick up the object 4 cm to the left
        this.moveX(-4); // Move to x=-4
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grasp the object
        this.moveY(2); // Lift the object back to the default height

        // Move to the drop coordinates
        this.moveX(8); // Move 8 units right to x=4
        this.moveZ(2); // Move 2 units forward to z=2
        this.moveY(1); // Move up to y=3

        // Drop the object from 1 cm height
        this.moveY(-1); // Lower to 1 cm above the target position
        this.openGripper(); // Release the object to drop it
        this.moveY(1); // Raise the arm back to the default height
    }
    // Partial. The coordinates were correct but it did not correctly drop the item from a height


    // "From origin, draw a square in the air with a side length of 3."
    public void drawSquareInAir() {
        this.returnToOrigin(); // Start at the origin

        // Move to starting position (keeping y at 2)
        this.moveX(-1.5); // Move left half the side length
        this.moveZ(-1.5); // Move backward half the side length

        // Draw the square
        this.moveX(3);  // Move right 3 units
        this.moveZ(3);  // Move forward 3 units
        this.moveX(-3); // Move left 3 units
        this.moveZ(-3); // Move backward 3 units

        // Return to center of square
        this.moveX(1.5); // Move right half the side length
        this.moveZ(1.5); // Move forward half the side length
    }
    // Passed

    // "19.	There are 3 objects. First is  at coordinates 3,0,1, second is at 4,0,2 and third at -2,0,2.
    // I want you to pick them and place them on top of each other at coordinates -5,0,5. The gripper can only hold one object at a time."
    public void stackObjects() {
        this.returnToOrigin(); // Start at the origin

        // Pick up and place the first object (from 3,0,1 to -5,0,5)
        this.moveX(3);
        this.moveZ(1);
        this.pickupObject();
        this.moveX(-8); // Move to x=-5
        this.moveZ(4);  // Move to z=5
        this.placeObject();

        // Pick up and place the second object (from 4,0,2 to -5,1,5)
        this.moveX(9);  // Move to x=4
        this.moveZ(-3); // Move to z=2
        this.pickupObject();
        this.moveX(-9); // Move to x=-5
        this.moveZ(3);  // Move to z=5
        this.moveY(1);  // Move up 1 unit to place on top of first object
        this.placeObject();

        // Pick up and place the third object (from -2,0,2 to -5,2,5)
        this.moveX(3);  // Move to x=-2
        this.moveZ(-3); // Move to z=2
        this.moveY(-2); // Move down to ground level
        this.pickupObject();
        this.moveX(-3); // Move to x=-5
        this.moveZ(3);  // Move to z=5
        this.moveY(4);  // Move up 4 units to place on top of second object
        this.placeObject();
    }

    // Helper method to pick up an object
    private void pickupObject() {
        this.openGripper();
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper();
        this.moveY(2);  // Lift object back to default height
    }

    // Helper method to place an object
    private void placeObject() {
        this.moveY(-1); // Lower object by 1 unit
        this.openGripper();
        this.moveY(1);  // Raise arm back to default height
    }
    // Partial. Incorrect coordination on the Y axis.

    // "There are 2 objects are coordinates 3,0,2 and -3,0,2. Can you swap them around"
    public void swapObjects() {
        this.returnToOrigin(); // Start at the origin

        // Step 1: Move the object from (3,0,2) to a temporary position (0,0,2)
        this.moveX(3);
        this.moveZ(2);
        this.pickupObject2();
        this.moveX(-3); // Move to x=0
        this.placeObject2();

        // Step 2: Move the object from (-3,0,2) to (3,0,2)
        this.moveX(-3);
        this.pickupObject2();
        this.moveX(6); // Move to x=3
        this.placeObject2();

        // Step 3: Move the object from temporary position (0,0,2) to (-3,0,2)
        this.moveX(-3); // Move to x=0
        this.pickupObject2();
        this.moveX(-3); // Move to x=-3
        this.placeObject2();
    }

    // Helper method to pick up an object
    private void pickupObject2() {
        this.openGripper();
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper();
        this.moveY(2);  // Lift object back to default height
    }

    // Helper method to place an object
    private void placeObject2() {
        this.moveY(-2); // Lower object to ground level
        this.openGripper();
        this.moveY(2);  // Raise arm back to default height
    }
    // Passed

    // "Pickup the object at 2,0,2 and throw it forward"
    public void throwObject() {
        // Move to the object's position
        this.returnToOrigin();
        this.moveX(2);
        this.moveZ(2);

        // Pick up the object
        this.openGripper();
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper();
        this.moveY(2); // Lift the object

        // Simulate throwing by moving forward quickly and releasing
        this.moveZ(5); // Move forward quickly (adjust distance as needed)
        this.openGripper(); // Release the object

        // Return arm to default position
        this.moveY(2);

        System.out.println("Object picked up from (2,0,2) and thrown forward.");
    }
    // Passed. The movements would mimic throwing an object forward.

    // "Pickup the last two objects moved and place them next to each other at coords -5,0,7"
    public void placeObjectsSideBySide() {
        // Assume the first object is at (2,0,7) (from the "throw" action)
        // and the second object is at (3,0,0) (from a previous example)

        // Pick up the first object
        this.returnToOrigin();
        this.moveX(2);
        this.moveZ(7);
        this.openGripper();
        this.moveY(-2);
        this.closeGripper();
        this.moveY(2);

        // Move to the destination and place the first object
        this.moveX(-7); // Move to x=-5
        this.moveZ(0);  // Ensure we're at z=7
        this.moveY(-2);
        this.openGripper();
        this.moveY(2);

        // Pick up the second object
        this.returnToOrigin();
        this.moveX(3);
        this.openGripper();
        this.moveY(-2);
        this.closeGripper();
        this.moveY(2);

        // Move to the destination and place the second object next to the first
        this.moveX(-8); // Move to x=-5
        this.moveZ(7);
        this.moveY(-2);
        this.openGripper();
        this.moveY(2);

        System.out.println("Two objects picked up and placed at (-5,0,7) and (-4,0,7)");
    }
    // Failed. Incorrect object location, followed by incorrect placement of objects.





    public static void main(String[] args) {
        Robot_Claude3_5Sonnet r = new Robot_Claude3_5Sonnet();
        r.getPosition();
    }
}
