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
    // method called when the robot is asked to do something outside of its abilities.
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

    // Adding functions from the LLM here


    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    public void pickUpObjectLeft7Forward4() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(4); // Move 4 cm forward
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.returnToOrigin(); // Return to the origin
    }

    // "pickup object at 4,0,3"
    public void pickUpObject4_0_3() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(4); // Move 4 cm to the right
        this.moveZ(3); // Move 3 cm forward
        this.openGripper(); // Open the gripper
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2); // Lift the object 2 cm
        this.returnToOrigin(); // Return to the origin
    }

    // "pickup object at 3,0,9 and do not return to origin"
    public void pickUpObject3_0_9Remain() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(3); // Move 3 cm to the right
        this.moveZ(9); // Move 9 cm forward
        this.openGripper(); // Open the gripper
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Close the gripper to pick up the object
        this.moveY(2); // Lift the object 2 cm
        // Do not return to origin
    }


    // "move the object that is 4 cm to the left, another 2 cm to the left"
    public void moveObjectLeft4Then2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-4); // Move 4 cm to the left
        this.moveZ(0); // Assume the object is at ground level
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(-2); // Move another 2 cm to the left
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm back up
        this.returnToOrigin(); // Return to the origin
    }
    // "move the object from 5,0,1 to 3,2,1. do not return to origin"
    public void moveObject5_0_1To3_2_1() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(5); // Move to the object's starting x position
        this.moveZ(1); // Move to the object's starting z position
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
        this.moveX(-2); // Move to the target x position
        this.moveY(2); // Move to the target y position
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        // Do not return to origin
    }

    // "pickup the object situated 2 cm to the right"
    public void pickUpObjectRight2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(2); // Move 2 cm to the right
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.returnToOrigin(); // Return to the origin
    }

    // "pickup the object situated 2 cm to the right and place it at position 5,0,5. do not return to origin"
    public void pickUpObjectRight2Place5_0_5Remain() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(2); // Move 2 cm to the right
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(3); // Move to the target x position (5 - 2 = 3)
        this.moveZ(5); // Move to the target z position
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        // Do not return to origin
    }
    // "take the object situated 4 cm to the left and move it 5 cm to the right. do not return to origin"
    public void pickUpObjectLeft4MoveRight5Remain() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-4); // Move 4 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm 2 cm to reach the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object 2 cm
        this.moveX(5); // Move 5 cm to the right
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        // Do not return to origin
    }
    // "move the object situated 2 cm to the left to origin."
    public void moveObjectLeft2ToOrigin() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(-2); // Move 2 cm to the left
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
        this.returnToOrigin(); // Move to the origin
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        this.returnToOrigin(); // Return to the origin
    }
    // "move the object from 3,0,3 forward 2 cm"
    public void moveObject3_0_3Forward2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        this.moveX(3); // Move to the object's x position
        this.moveZ(3); // Move to the object's z position
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
        this.moveZ(2); // Move 2 cm forward
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        this.returnToOrigin(); // Return to the origin
    }
    // "Pickup last object placed and move it 2 cm to the left. do not return to origin"
    public void pickUpLastObjectMoveLeft2Remain() {
        // Assuming the last object was placed at 3, 0, 5 (from previous instruction)
        this.moveX(3); // Move to the object's x position
        this.moveZ(5); // Move to the object's z position
        this.openGripper(); // Open the gripper before lowering
        this.moveY(-2); // Lower the arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object
        this.moveX(-2); // Move 2 cm to the left
        this.moveY(-2); // Lower the arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        // Do not return to origin
    }

    // Main method to create a robot instance
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.getPosition();
        robot.moveX(5);
        robot.getPosition();

        robot.pickUpObjectLeft7Forward4();
        robot.pickUpObject4_0_3();
        robot.pickUpObject3_0_9Remain();

    }

}
