package HRI;


import java.util.ArrayList;
import java.util.List;

public class Robot {
    public double x;
    public double y;
    public double z;
    public ArrayList<Double> coords = new ArrayList<>();
    public List<ObjectHRI> objects;
    public boolean gripperIsOpen;

    // Constructor to initialize the robot's position at coordinates (x, y)
    public Robot() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
        this.objects = new ArrayList<>();
        this.gripperIsOpen = false;
    }
    public Robot(double X, double Y, double Z) {
        this.x = X;
        this.y = Y;
        this.z = Z;
        this.objects = new ArrayList<>();
        this.gripperIsOpen = false;
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
        this.gripperIsOpen = true;
    }
    public void closeGripper() {
        this.gripperIsOpen = false;
    }


    // Adding functions from ChatGPT 3.5

    // "pickup object at 3,0,9 and return to origin"
    public void pickUpObjectAt3_0_9AndReturnToOrigin() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(3, 0, 9); // Instantiate the object

        // Move to the object's position
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(9); // Move 9 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Return to origin with the object
        this.moveX(-3); // Move 3 cm to the left
        o1.setX(this.getX());

        this.moveZ(-9); // Move 9 cm backward
        o1.setZ(this.getZ());

        // Place the object at the origin
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (3, 0, 9) and returned to origin.");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot returned to origin. Position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    public void pickUpObjectLeft7Forward4AndReturnToOrigin() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(-7, 0, 4); // Instantiate the object at (-7, 0, 4)

        // Move to the object's position
        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(4);  // Move 4 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Return to origin with the object
        this.moveX(7); // Move 7 cm to the right
        o1.setX(this.getX());

        this.moveZ(-4); // Move 4 cm backward
        o1.setZ(this.getZ());

        // Place the object at the origin
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (-7, 0, 4) and returned to origin.");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot returned to origin. Position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "pickup the object situated 2 cm to the right from origin and move it at coordinates (-2,0,2)"
    public void pickUpObjectRight2AndMoveToNegative2_0_2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(2, 0, 0); // Instantiate the object at (2, 0, 0)

        // Move to the object's position
        this.moveX(2); // Move 2 cm to the right

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the new coordinates (-2, 0, 2)
        this.moveX(-4); // Move 4 cm to the left (2 cm back to origin + 2 cm further to -2)
        o1.setX(this.getX());

        this.moveZ(2); // Move 2 cm forward
        o1.setZ(this.getZ());

        // Place the object at the new coordinates
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        // Return to origin
        this.returnToOrigin();

        System.out.println("Object picked up from (2, 0, 0) and moved to (-2, 0, 2).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot returned to origin. Position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "place the object at 4,0,1 two cm forward on the ground"
    public void placeObjectAt4_0_1TwoCmForward() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(4, 0, 1); // Instantiate the object at (4, 0, 1)

        // Move to the object's position
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(1); // Move 1 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object 2 cm forward
        this.moveZ(2); // Move 2 cm forward
        o1.setZ(this.getZ()); // Update object's Z coordinate

        // Place the object at the new coordinates
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (4, 0, 1) and moved to (4, 0, 3).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot position after placing object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "move the arm 2 cm to the left from origin. pickup the object situated on the ground 3 cm to the right from  your position and place it at position 5,0,5. do not return to origin"
    public void moveArmLeft2PickUpRight3AndPlaceAt5_0_5() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move 2 cm to the left from origin
        this.moveX(-2);

        // Move to the object's position, 3 cm to the right from the current position (1 cm to the right from origin)
        this.moveX(3);
        ObjectHRI o1 = new ObjectHRI(1, 0, 0); // Instantiate the object at (1, 0, 0)

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the new coordinates (5, 0, 5)
        this.moveX(4); // Move 4 cm to the right to reach x=5
        o1.setX(this.getX());

        this.moveZ(5); // Move 5 cm forward to reach z=5
        o1.setZ(this.getZ());

        // Place the object at the new coordinates
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (1, 0, 0) and moved to (5, 0, 5).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot position after placing object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "move the object situated 2 cm to the left from origin to origin"
    public void moveObjectLeft2ToOrigin() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(-2, 0, 0); // Instantiate the object at (-2, 0, 0)

        // Move to the object's position
        this.moveX(-2); // Move 2 cm to the left

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the origin
        this.moveX(2); // Move 2 cm to the right to reach the origin
        o1.setX(this.getX()); // Update object's X coordinate

        // Place the object at the origin
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (-2, 0, 0) and moved to (0, 0, 0).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot position after placing object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "Pickup last object placed and place it on the ground 2 cm to the left. do not return to origin"
    public void pickUpLastObjectAndPlace2CmLeft() {
        // Assume that the last object placed was at (5, 0, 5) as per the previous task.

        // Move to the position of the last object
        this.moveX(5); // Move 5 cm to the right
        this.moveZ(5); // Move 5 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update the object's coordinates to match the robot's position
        ObjectHRI lastObject = new ObjectHRI(5, 0, 5);
        lastObject.setX(this.getX());
        lastObject.setY(this.getY());
        lastObject.setZ(this.getZ());

        // Move the object 2 cm to the left
        this.moveX(-2); // Move 2 cm to the left
        lastObject.setX(this.getX()); // Update object's X coordinate

        // Place the object at the new position on the ground
        this.moveY(-2); // Lower the arm to ground level
        lastObject.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object picked up from (5, 0, 5) and placed at (3, 0, 5).");
        System.out.println("Final object position: (" + lastObject.getX() + ", " + lastObject.getY() + ", " + lastObject.getZ() + ")");
        System.out.println("Robot position after placing object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed

    // "place the object situated at 2,1,2 on the ground 4 cm to the left"
    public void placeObjectFrom2_1_2To4CmLeftOnGround() {
        // Initialize the object at the starting position (2, 1, 2)
        ObjectHRI o1 = new ObjectHRI(2, 1, 2);

        // Move to the position of the object
        this.moveX(2);  // Move to the x-coordinate of the object's position
        this.moveY(-1); // Move down from y=2 to y=1 (object's y-coordinate)
        this.moveZ(2);  // Move to the z-coordinate of the object's position

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-1); // Lower the arm to ground level (y=0)
        this.closeGripper(); // Grip the object
        this.moveY(1);  // Lift the object back to y=1

        // Update the object's coordinates to match the robot's position
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setY(this.getY()); // Update object's Y coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate

        // Move the object 4 cm to the left
        this.moveX(-4); // Move 4 cm to the left
        o1.setX(this.getX()); // Update object's X coordinate

        // Place the object on the ground at the new position
        this.moveY(-1); // Lower the arm to ground level (y=0)
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(1);  // Raise the arm to y=1 (default height)

        System.out.println("Object moved from (2, 1, 2) to (-2, 0, 2).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot position after placing object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed

    // "Take the object at 1,0,1 and place it at 2,0,1. Then take another object at 3,0,3 and place it one cm to the right."
    public void moveAndPlaceObjects() {
        // Step 1: Move the object from (1, 0, 1) to (2, 0, 1)
        // Initialize the first object at position (1, 0, 1)
        ObjectHRI o1 = new ObjectHRI(1, 0, 1);

        // Move to the object's position
        this.moveX(1);  // Move 1 cm to the right
        this.moveZ(1);  // Move 1 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to the ground level (y=0)
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2);  // Lift the object to y=2 (default height)

        // Update the object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the new position (2, 0, 1)
        this.moveX(1);  // Move 1 cm to the right
        o1.setX(this.getX()); // Update object's X coordinate

        // Place the object on the ground at (2, 0, 1)
        this.moveY(-2); // Lower the arm to ground level (y=0)
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2);  // Raise the arm back to y=2 (default height)

        System.out.println("Object moved from (1, 0, 1) to (2, 0, 1).");
        System.out.println("Final position of the first object: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Step 2: Move the object from (3, 0, 3) and place it 1 cm to the right
        // Initialize the second object at position (3, 0, 3)
        ObjectHRI o2 = new ObjectHRI(3, 0, 3);

        // Move to the second object's position
        this.moveX(2);  // Move 2 cm to the right
        this.moveZ(3);  // Move 3 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to the ground level (y=0)
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2);  // Lift the object to y=2 (default height)

        // Update the object's coordinates
        o2.setX(this.getX());
        o2.setY(this.getY());
        o2.setZ(this.getZ());

        // Move the object 1 cm to the right
        this.moveX(1);  // Move 1 cm to the right
        o2.setX(this.getX()); // Update object's X coordinate

        // Place the object on the ground at the new position (4, 0, 3)
        this.moveY(-2); // Lower the arm to ground level (y=0)
        o2.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2);  // Raise the arm back to y=2 (default height)

        System.out.println("Object moved from (3, 0, 3) to (4, 0, 3).");
        System.out.println("Final position of the second object: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot position after moving both objects: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed

    // "Take one object situated at 4,0,2 and place it on top of the object situated at cords -2,0,3"
    public void moveObjectAndPlaceOnTop() {
        // Step 1: Move the object from (4, 0, 2) to on top of the object at (-2, 0, 3)

        // Initialize the first object at position (4, 0, 2)
        ObjectHRI o1 = new ObjectHRI(4, 0, 2);

        // Move to the object's position
        this.moveX(4);  // Move 4 cm to the right
        this.moveZ(2);  // Move 2 cm forward

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to the ground level (y=0)
        this.closeGripper(); // Grip the object
        this.moveY(2);  // Lift the object to y=2 (default height)

        // Update the object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move to the target position to place the object on top of (-2, 0, 3)
        // Move to x = -2 and z = 3
        this.moveX(-6); // Move 6 cm to the left from x = 4 to x = -2
        this.moveZ(1);  // Move 1 cm forward from z = 2 to z = 3
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate

        // Place the object on top of the target object at (-2, 0, 3)
        this.moveY(-2); // Lower the arm to y = 0 (ground level) to place the object
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2);  // Raise the arm back to y = 2 (default height)

        System.out.println("Object moved from (4, 0, 2) to on top of (-2, 0, 3).");
        System.out.println("Final position of the object: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot position after moving the object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Running the code would create a collision between robot and second object

    // "Move an object from -2,0,2 at coordinates 3,0,2. Then pick it up and move it 2 cm to the left"
    public void moveAndShiftObject() {
        // Step 1: Move the object from (-2, 0, 2) to (3, 0, 2) and then move it 2 cm to the left

        // Initialize the object at position (-2, 0, 2)
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);

        // Move to the object's position
        this.moveX(-2);  // Move 2 cm to the left from the origin to x = -2
        this.moveZ(2);   // Move 2 cm forward to z = 2

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level (y = 0) to pick up the object
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2);  // Lift the object to y = 2 (default height)

        // Update the object's coordinates
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the new position (3, 0, 2)
        this.moveX(5);  // Move from x = -2 to x = 3 (total 5 cm to the right)
        o1.setX(this.getX()); // Update object's X coordinate

        // The object's Z and Y coordinates remain the same
        o1.setZ(this.getZ()); // Update object's Z coordinate

        // Move the object 2 cm to the left
        this.moveX(-2); // Move 2 cm to the left from x = 3 to x = 1
        o1.setX(this.getX()); // Update object's X coordinate

        // Place the object at the new position
        this.moveY(-2); // Lower the arm to ground level (y = 0) to place the object
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2);  // Raise the arm back to y = 2 (default height)

        System.out.println("Object moved from (-2, 0, 2) to (3, 0, 2) and then shifted 2 cm to the left.");
        System.out.println("Final position of the object: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot position after moving the object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not place the object at 3,0,2

    // "Pickup the object 4 cm to the left and drop it from 1 cm height to the coordinates 4,3,2"
    public void pickupAndDropObject() {
        // Step 1: Initialize the object at position (-4, 0, 0)
        ObjectHRI o1 = new ObjectHRI(-4, 0, 0);

        // Move to the object's position
        this.moveX(-4);  // Move 4 cm to the left from the origin to x = -4

        // Pick up the object
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level (y = 0) to pick up the object
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2);  // Lift the object to y = 2 (default height)

        // Update the object's coordinates to match the robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move to the destination position (4, 3, 2)
        this.moveX(8);  // Move from x = -4 to x = 4 (total 8 cm to the right)
        o1.setX(this.getX()); // Update object's X coordinate

        this.moveZ(2);  // Move from z = 0 to z = 2 (total 2 cm forward)
        o1.setZ(this.getZ()); // Update object's Z coordinate

        this.moveY(-2); // Move the arm from y = 2 to y = 0 to lower the object to the ground

        // Drop the object
        this.openGripper(); // Release the object
        this.moveY(2);  // Raise the arm back to y = 2 (default height)

        // Update the object's Y coordinate
        o1.setY(this.getY()); // Update object's Y coordinate to reflect the final placement

        System.out.println("Object picked up from (-4, 0, 0) and placed at (4, 3, 2).");
        System.out.println("Final position of the object: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot position after placing the object: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Incorrect Y coordinates

    // "From origin, draw a square in the air with a side length of 3."
    public void drawSquareInTheAir() {
        // Step 1: Move to the starting position at the origin
        this.returnToOrigin();  // Ensure the robot starts at the origin (0, 2, 0)

        // Step 2: Move to height for drawing the square
        this.moveY(2); // Raise the arm to height y = 2 (the default height for drawing the square)

        // Draw the square in the air with a side length of 3 cm

        // Move to the right to form the first side of the square
        this.moveX(3); // Move 3 cm to the right

        // Move forward to complete the second side of the square
        this.moveZ(3); // Move 3 cm forward

        // Move to the left to complete the third side of the square
        this.moveX(-3); // Move 3 cm to the left

        // Move backward to complete the fourth side of the square and return to the origin
        this.moveZ(-3); // Move 3 cm backward

        // Optionally, return to the origin
        //this.returnToOrigin(); // Uncomment this line if you want to return to the origin

        System.out.println("Square drawn with a side length of 3 cm in the air.");
        System.out.println("Current robot position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "There are 3 objects. First is  at coordinates 3,0,1, second is at 4,0,2 and third at -2,0,2. I want you to pick them and place them on top of each other at coordinates -5,0,5. The gripper can only hold one object at a time."
    public void moveObjectsToNewLocation() {
        // Coordinates for the objects
        int[] firstObject = {3, 0, 1};
        int[] secondObject = {4, 0, 2};
        int[] thirdObject = {-2, 0, 2};

        // Destination coordinates
        int destinationX = -5;
        int destinationY = 0;
        int destinationZ = 5;

        // Move and handle the first object
        moveToAndPickUpObject(firstObject[0], firstObject[1], firstObject[2]); // Move to (3, 0, 1)
        this.moveX(destinationX - this.getX()); // Move to the target x-coordinate
        this.moveY(destinationY - this.getY()); // Move to the target y-coordinate (ground level)
        this.moveZ(destinationZ - this.getZ()); // Move to the target z-coordinate

        // Update the object's position and place it
        this.openGripper(); // Release the object at the new location
        this.moveY(2); // Raise the arm back up
        System.out.println("Placed first object at (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");

        // Pick up the second object
        moveToAndPickUpObject(secondObject[0], secondObject[1], secondObject[2]); // Move to (4, 0, 2)
        this.moveX(destinationX - this.getX()); // Move to the target x-coordinate
        this.moveY(destinationY - this.getY()); // Move to the target y-coordinate (ground level)
        this.moveZ(destinationZ - this.getZ()); // Move to the target z-coordinate

        // Update the object's position and place it on top of the first object
        this.openGripper(); // Release the object at the new location
        this.moveY(2); // Raise the arm back up
        System.out.println("Placed second object at (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");

        // Pick up the third object
        moveToAndPickUpObject(thirdObject[0], thirdObject[1], thirdObject[2]); // Move to (-2, 0, 2)
        this.moveX(destinationX - this.getX()); // Move to the target x-coordinate
        this.moveY(destinationY - this.getY()); // Move to the target y-coordinate (ground level)
        this.moveZ(destinationZ - this.getZ()); // Move to the target z-coordinate

        // Update the object's position and place it on top of the second object
        this.openGripper(); // Release the object at the new location
        this.moveY(2); // Raise the arm back up
        System.out.println("Placed third object at (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }

    // Helper method to move to the object's position and pick it up
    private void moveToAndPickUpObject(int x, int y, int z) {
        // Move to the object's position
        this.moveX(x - this.getX()); // Move in the x-direction
        this.moveY(y - this.getY()); // Move in the y-direction
        this.moveZ(z - this.getZ()); // Move in the z-direction

        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the gripper to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object to the default height
        System.out.println("Picked up object at (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not create/use instances of ObjectHRI class

    // "There are 2 objects are coordinates 3,0,2 and -3,0,2. Can you swap them around"
    public void swapObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Define the objects at the given coordinates
        ObjectHRI object1 = new ObjectHRI(3, 0, 2); // Object at (3, 0, 2)
        ObjectHRI object2 = new ObjectHRI(-3, 0, 2); // Object at (-3, 0, 2)

        // Move to the position of the first object
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(2); // Move 2 cm forward

        this.openGripper(); // Open gripper before lowering
        this.moveY(-2); // Lower to ground level
        this.closeGripper(); // Grip the first object
        this.moveY(2); // Lift the object

        // Update the first object's coordinates
        object1.setX(this.getX());
        object1.setY(this.getY());
        object1.setZ(this.getZ());

        // Move to the position of the second object
        this.moveX(-6); // Move 6 cm to the left (from 3 to -3)
        this.moveZ(0);  // Move to the z-coordinate of the second object

        // Update the second object's coordinates to match the robot's position
        object2.setX(this.getX());
        object2.setY(this.getY());
        object2.setZ(this.getZ());

        // Place the first object at the original position of the second object
        this.moveY(-2); // Lower to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        // Move back to the original position of the first object
        this.moveX(6); // Move 6 cm to the right (from -3 back to 3)
        this.moveZ(2); // Move back to the z-coordinate of the first object

        // Update the first object's coordinates
        object1.setX(this.getX());
        object1.setY(this.getY());
        object1.setZ(this.getZ());

        // Pick up the second object
        this.openGripper(); // Open gripper before lowering
        this.moveY(-2); // Lower to ground level
        this.closeGripper(); // Grip the second object
        this.moveY(2); // Lift the object

        // Update the second object's coordinates
        object2.setX(this.getX());
        object2.setY(this.getY());
        object2.setZ(this.getZ());

        // Move to the position of the first object
        this.moveX(-6); // Move 6 cm to the left
        this.moveZ(0);  // Move to the z-coordinate of the first object

        // Place the second object at the original position of the first object
        this.moveY(-2); // Lower to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        // Return to the origin
        this.returnToOrigin();

        System.out.println("Objects swapped.");
        System.out.println("First object position: (" + object1.getX() + ", " + object1.getY() + ", " + object1.getZ() + ")");
        System.out.println("Second object position: (" + object2.getX() + ", " + object2.getY() + ", " + object2.getZ() + ")");
        System.out.println("Robot returned to origin. Position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. First object would collide with second object.

    // "Pickup the last two objects moved and place them next to each other at coords -5,0,7"
    public void pickUpAndPlaceLastTwoObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Define the objects at the coordinates where the last two objects were moved
        // Assuming the last two objects are at (3, 0, 2) and (-3, 0, 2)
        ObjectHRI object1 = new ObjectHRI(3, 0, 2); // Last moved object at (3, 0, 2)
        ObjectHRI object2 = new ObjectHRI(-3, 0, 2); // Second last moved object at (-3, 0, 2)

        // Define the target position for the two objects to be placed next to each other
        int targetX = -5;
        int targetZ = 7;

        // Move to the position of the first object
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(2); // Move 2 cm forward

        this.openGripper(); // Open gripper before lowering
        this.moveY(-2); // Lower to ground level
        this.closeGripper(); // Grip the first object
        this.moveY(2); // Lift the object

        // Update the first object's coordinates
        object1.setX(this.getX());
        object1.setY(this.getY());
        object1.setZ(this.getZ());

        // Move to the position of the second object
        this.moveX(-6); // Move 6 cm to the left (from 3 to -3)
        this.moveZ(0);  // Move to the z-coordinate of the second object

        // Update the second object's coordinates to match the robot's position
        object2.setX(this.getX());
        object2.setY(this.getY());
        object2.setZ(this.getZ());

        // Place the first object at the target position
        this.moveY(-2); // Lower to ground level
        this.openGripper(); // Release the first object
        this.moveY(2); // Raise the arm

        // Move to the target position for the second object
        this.moveX(targetX - this.getX()); // Move to the x-coordinate of the target position
        this.moveZ(targetZ - this.getZ()); // Move to the z-coordinate of the target position

        // Update the target position for the second object
        object1.setX(this.getX());
        object1.setY(this.getY());
        object1.setZ(this.getZ());

        // Place the second object next to the first one
        this.openGripper(); // Release the second object
        this.moveY(2); // Raise the arm

        // Move the robot to the new position for the second object
        this.moveX(-1); // Move 1 cm to the left (next to the first object)

        // Pick up the second object
        this.openGripper(); // Open gripper before lowering
        this.moveY(-2); // Lower to ground level
        this.closeGripper(); // Grip the second object
        this.moveY(2); // Lift the object

        // Update the second object's coordinates
        object2.setX(this.getX());
        object2.setY(this.getY());
        object2.setZ(this.getZ());

        // Move to the target position for the first object
        this.moveX(targetX - this.getX()); // Move to the x-coordinate of the target position
        this.moveZ(targetZ - this.getZ()); // Move to the z-coordinate of the target position

        // Place the second object at the new position
        this.moveY(-2); // Lower to ground level
        this.openGripper(); // Release the second object
        this.moveY(2); // Raise the arm

        // Return to the origin
        this.returnToOrigin();

        System.out.println("Objects placed next to each other at (" + (-5) + ", " + 0 + ", " + 7 + ").");
        System.out.println("First object position: (" + object1.getX() + ", " + object1.getY() + ", " + object1.getZ() + ")");
        System.out.println("Second object position: (" + object2.getX() + ", " + object2.getY() + ", " + object2.getZ() + ")");
        System.out.println("Robot returned to origin. Position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Incorrect placement of objects.





    // Main method to create a robot instance
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.getPosition();
        robot.moveX(5);
        robot.getPosition();
    }

}
