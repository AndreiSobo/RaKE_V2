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
    public void pickupObjectAt4_0_3() {
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
    public void pickupObjectAt3_0_9AndReturnToOrigin() {
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
    public void moveObjectLeftAndPlaceOnGround() {
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

    //


    public static void main(String[] args) {
        Robot_Claude3_5Sonnet r = new Robot_Claude3_5Sonnet();
        r.getPosition();
    }
}
