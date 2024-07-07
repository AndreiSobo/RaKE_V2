package HRI;


import java.util.ArrayList;

public class Robot {
    public double x;
    public double y;
    public double z;
    public ArrayList<Double> coords = new ArrayList<>();

    // Constructor to initialize the robot's position at coordinates (x, y)
    public Robot() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
    }
    public Robot(double X, double Y, double Z) {
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

    // Adding functions from the Gemini 1.5 Flash LLM here

    // "pickup object at 4,0,3"
    public void pickUpObjectAt4_0_3() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(3); // Move 3 cm forward
        this.openGripper(); // Open the gripper before lowering to the object
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
    }
    // Passed

    // "pickup object at 3,0,9 and return to origin"
    public void pickUpObjectAt3_0_9AndReturn() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(9); // Move 9 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.returnToOrigin(); // Return to the origin
    }
    // Passed

    // "move the object that is 4 cm to the left from origin, another 2 cm to the left and place it on the ground"
    public void moveObjectLeftAndPlace() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-4); // Move 4 cm to the left
        this.moveX(-2); // Move another 2 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
    }
    // Failed.

    // "move the object from 5,0,1 to 3,2,1. do not return to origin"
    public void moveObjectFrom5_0_1To3_2_1() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(5); // Move 5 cm to the right
        this.moveZ(1); // Move 1 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(-2); // Move 2 cm to the left
        this.moveY(2); // Move 2 cm up
        // Do not return to origin
    }
    // Failed.

    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    public void pickUpObjectLeftAndForward() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(4); // Move 4 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
    }
    // Passed

    // "pickup the object situated 2 cm to the right from origin"
    public void pickUpObjectRight() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(2); // Move 2 cm to the right
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
    }
    // Passed

    // "place the object situated at 4,0,1 two cm forward on the ground"
    public void placeObjectForwardOnGround() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(1); // Move 1 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to the ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
        this.moveZ(2); // Move 2 cm forward
        this.moveY(-2); // Lower the arm to place the object on the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
    }
    // Passed

    // "move the arm 2 cm to the left from origin. pickup the object situated on the ground 3 cm to the right from  your position and place it at position 5,0,5. do not return to origin"
    public void pickUpAndPlaceObject() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-2); // Move 2 cm to the left from origin
        this.moveX(3); // Move 3 cm to the right from current position
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(2); // Move 2 cm to the right (to reach the target position)
        this.moveZ(5); // Move 5 cm forward
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
        // Do not return to origin
    }
    // Failed.

    // "take the object situated 4 cm to the left and move it 5 cm to the right. Do not return to origin"
    public void moveObjectRight() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-4); // Move 4 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(5); // Move 5 cm to the right
        // Do not return to origin
    }
    // Passed

    // "move the object situated 2 cm to the left from origin to origin"
    public void moveObjectToOrigin() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-2); // Move 2 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(2); // Move 2 cm to the right (back to origin)
        // Do not return to origin (as the robot is already at the origin)
    }
    // Passed

    // "place the object from -3,0,3 forward 2 cm on the ground then return to origin"
    public void placeObjectForwardAndReturn() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-3); // Move 3 cm to the left
        this.moveZ(3); // Move 3 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveZ(2); // Move 2 cm forward
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
        this.returnToOrigin(); // Return to the origin
    }
    // Passed

    // "Pickup last object placed and place it on the ground 2 cm to the left. do not return to origin"
    public void pickUpAndPlaceLeft() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveZ(5); // Move 5 cm forward (to the last object's position)
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveZ(-5); // Move 5 cm backward (back to origin)
        this.moveX(-2); // Move 2 cm to the left
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
        // Do not return to origin
    }
    // Failed

    // "place the object situated at 2,1,2 on the ground 4 cm to the left"
    public void placeObjectLeft() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(2); // Move 2 cm to the right
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-1); // Lower the arm 1 cm to reach the object (since it's at y=1)
        this.closeGripper(); // Grip the object
        this.moveY(1); // Lift the object 1 cm
        this.moveX(-4); // Move 4 cm to the left
        this.moveY(-1); // Lower the arm 1 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(1); // Raise the arm back to default height
    }
    // Failed

    // "Take the object at 1,0,1 and place it at 2,0,1. Then take another object at 3,0,3 and place it one cm to the right"
    public void moveTwoObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move the first object
        this.moveX(1); // Move 1 cm to the right
        this.moveZ(1); // Move 1 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(1); // Move 1 cm to the right
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height

        // Move the second object
        this.moveX(2); // Move 2 cm to the right (to reach the second object)
        this.moveZ(3); // Move 3 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(1); // Move 1 cm to the right
        this.moveY(-2); // Lower the arm 2 cm to reach the ground
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
    }
    // Failed.

    // "Take one object situated at 4,0,2 and place it on top of the object situated at cords -2,0,3"
    public void placeObjectOnTop() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the first object
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the second object
        this.moveX(-6); // Move 6 cm to the left
        this.moveZ(1); // Move 1 cm forward

        // Place the first object on top of the second object
        this.moveY(-1); // Lower the arm 1 cm to place the object on top
        this.openGripper(); // Release the object
        this.moveY(1); // Raise the arm back to default height
    }
    // Passed

    // "Move an object from -2,0,2 at coordinates 3,0,2. Then pick it up and move it 2 cm to the left"
    public void moveObjectAndPickUp() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move the object to 3,0,2
        this.moveX(-2); // Move 2 cm to the left
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(5); // Move 5 cm to the right (to reach 3,0,2)

        // Pick up the object and move it 2 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(-2); // Move 2 cm to the left
    }
    // Failed

    // "Pickup the object 4 cm to the left and drop it from 1 cm height to the coordinates 4,3,2"
    public void pickUpAndDrop() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the object
        this.moveX(-4); // Move 4 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the drop location
        this.moveX(8); // Move 8 cm to the right (to reach 4,0,2)
        this.moveZ(2); // Move 2 cm forward

        // Drop the object from 1 cm height
        this.moveY(-1); // Lower the arm 1 cm
        this.openGripper(); // Release the object
        this.moveY(1); // Raise the arm back to default height
    }
    // Failed.

    // "From origin, draw a square in the air with a side length of 3."
    public void drawSquareInAir() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move 3 units to the right
        this.moveX(3);

        // Move 3 units up
        this.moveY(3);

        // Move 3 units to the left
        this.moveX(-3);

        // Move 3 units down
        this.moveY(-3);
    }
    // Passed

    // "There are 3 objects. First is at coordinates 3,0,1, second is at 4,0,2 and third at -2,0,2. I want you to pick them
    // and place them on top of each other at coordinates -5,0,5. The gripper can only hold one object at a time."
    public void stackObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the first object
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(1); // Move 1 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the stacking location
        this.moveX(-8); // Move 8 cm to the left
        this.moveZ(4); // Move 4 cm forward

        // Place the first object
        this.moveY(-1); // Lower the arm 1 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(1); // Raise the arm back to default height

        // Pick up the second object
        this.moveX(9); // Move 9 cm to the right (to reach the second object)
        this.moveZ(-2); // Move 2 cm backward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move back to the stacking location
        this.moveX(-9); // Move 9 cm to the left
        this.moveZ(2); // Move 2 cm forward

        // Place the second object on top of the first
        this.moveY(-2); // Lower the arm 2 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height

        // Pick up the third object
        this.moveX(6); // Move 6 cm to the right (to reach the third object)
        this.moveZ(-2); // Move 2 cm backward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move back to the stacking location
        this.moveX(-6); // Move 6 cm to the left
        this.moveZ(2); // Move 2 cm forward

        // Place the third object on top of the stack
        this.moveY(-3); // Lower the arm 3 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(3); // Raise the arm back to default height
    }
    // Failed. Miscalculated coordinates and stack order.

    // "There are 2 objects are coordinates 3,0,2 and -3,0,2. Can you swap them around."
    public void swapObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the first object
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the second object's position
        this.moveX(-6); // Move 6 cm to the left

        // Place the first object
        this.moveY(-2); // Lower the arm 2 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height

        // Pick up the second object
        this.moveX(6); // Move 6 cm to the right
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the first object's original position
        this.moveX(-6); // Move 6 cm to the left

        // Place the second object
        this.moveY(-2); // Lower the arm 2 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
    }
    // Failed.

    // "Pickup the object at 2,0,2 and throw it forward"
    public void throwObject() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the object
        this.moveX(2); // Move 2 cm to the right
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move forward and release the object
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Release the object
        System.out.println("Object thrown forward!");
    }
    // Partial

    // "Pickup the last two objects moved and place them next to each other at coords -5,0,7"
    public void placeObjectsSideBySide() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Pick up the first object (assuming it's at 2,0,4)
        this.moveX(2); // Move 2 cm to the right
        this.moveZ(4); // Move 4 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the target location
        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(3); // Move 3 cm forward

        // Place the first object
        this.moveY(-2); // Lower the arm 2 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height

        // Pick up the second object (assuming it's at 4,0,6)
        this.moveX(2); // Move 2 cm to the right
        this.moveZ(2); // Move 2 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm

        // Move to the target location next to the first object
        this.moveX(-2); // Move 2 cm to the left

        // Place the second object
        this.moveY(-2); // Lower the arm 2 cm to place the object
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm back to default height
    }
    // Failed.


    // Main method to create a robot instance
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.getPosition();
        robot.moveX(5);
        robot.getPosition();
    }

}
