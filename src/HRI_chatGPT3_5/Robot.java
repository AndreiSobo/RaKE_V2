package HRI_chatGPT3_5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class Robot {
    private int x;
    private int y;
    private int z;
    protected List<ObjectHRI> objects;
    public boolean gripperIsOpen;
    protected ArrayList<Integer> coords;

    public Robot() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
        this.objects = new ArrayList<>();
        this.gripperIsOpen = true;
        this.coords = new ArrayList<>();
    }

    public Robot(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.objects = new ArrayList<>();
        this.gripperIsOpen = true;
        this.coords = new ArrayList<>();
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getZ() { return this.z; }

    public ArrayList<Integer> getPosition() {
        coords.clear();  // Clear previous coordinates
        coords.add(getX());
        coords.add(getY());
        coords.add(getZ());
        System.out.println("Position: (" + this.x + ", " + this.y + ", " + this.z + ")");
        return coords;
    }

    public void moveX(int distance) {
        int newX = this.x + distance;
        checkCollision(newX, this.y, this.z);
        this.x = newX;
        System.out.println("Robot moved on x axis. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    public void moveY(int distance) {
        int newY = this.y + distance;
        checkCollision(this.x, newY, this.z);
        this.y = newY;
        System.out.println("Robot moved on y axis. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    public void moveZ(int distance) {
        int newZ = this.z + distance;
        checkCollision(this.x, this.y, newZ);
        this.z = newZ;
        System.out.println("Robot moved on z axis. New position: (" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    private void checkCollision(int newX, int newY, int newZ) {
        System.out.println("Checking collision for position: (" + newX + ", " + newY + ", " + newZ + ")");
        System.out.println("Gripper is " + (gripperIsOpen ? "open" : "closed"));
        if (!gripperIsOpen) {
            for (ObjectHRI obj : objects) {
                System.out.println("Comparing with object at: (" + obj.getX() + ", " + obj.getY() + ", " + obj.getZ() + ")");
                if (newX == obj.getX() && newY == obj.getY() && newZ == obj.getZ()) {
                    throw new IllegalStateException("Collision detected! Cannot move to object coordinates with closed gripper.");
                }
            }
        }
        System.out.println("No collision detected");
    }

    public void openGripper() {
        this.gripperIsOpen = true;
        System.out.println("Gripper opened.");
    }

    public void closeGripper() {
        checkCollision(this.x, this.y, this.z);
        this.gripperIsOpen = false;
        System.out.println("Gripper closed.");
    }

    public void addObject(ObjectHRI obj) {
        this.objects.add(obj);
    }

    public void returnToOrigin() {
        this.x = 0;
        this.y = 2;
        this.z = 0;
        System.out.println("Robot returned to origin (0, 2, 0)");
    }

    // Adding functions from ChatGPT 3.5

    // "pickup object at (3,0,9). Do not return to origin"
    public void pickUpObjectAt3_0_9DoNotReturn() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(3, 0, 9); // Instantiate the object
        this.addObject(o1); // Add the object to the robot's environment

        this.moveX(3); // Move to object's x-coordinate
        this.moveZ(9); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        System.out.println("Object picked up. New position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "pickup object that is 7 cm to the left and 4 cm forward of origin"
    public void pickUpObject7CmLeftAnd4CmForward() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(-7, 0, 4); // Instantiate the object
        this.addObject(o1); // Add the object to the robot's environment

        this.moveX(-7); // Move 7 cm to the left
        this.moveZ(4); // Move 4 cm forward

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        System.out.println("Object picked up. New position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "pickup the object situated 2 cm to the right from origin and move it at coordinates (-2,0,2)"
    public void pickUpObjectAndMoveToMinus2_0_2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(2, 0, 0); // Instantiate the object
        this.addObject(o1); // Add the object to the robot's environment

        this.moveX(2); // Move 2 cm to the right to reach the object's position

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the target position (-2, 0, 2)
        this.moveX(-4); // Move 4 cm to the left from x=2 to x=-2
        o1.setX(this.getX());

        this.moveZ(2); // Move 2 cm forward to z=2
        o1.setZ(this.getZ());

        // Place the object
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object moved from (2, 0, 0) to (-2, 0, 2).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "place the object situated at (4,0,1) two cm forward on the ground"
    public void placeObjectAt4_0_1TwoCmForward() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(4, 0, 1); // Instantiate the object
        this.addObject(o1); // Add the object to the robot's environment

        this.moveX(4); // Move to object's x-coordinate
        this.moveZ(1); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object 2 cm forward
        this.moveZ(2); // Move 2 cm forward
        o1.setZ(this.getZ()); // Update object's Z coordinate

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object placed at (4, 0, 3).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin.

    //"move 2 cm to the left from origin. pickup the object situated on the ground 3 cm to the right from  your position and place it at coordinates (5,0,5). do not return to origin"
    public void moveLeftPickUpAndPlaceObject() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move 2 cm to the left from the origin
        this.moveX(-2);

        // Instantiate the object located 3 cm to the right from the current position
        ObjectHRI o1 = new ObjectHRI(1, 0, 0); // Current position after moving left: (-2, 0, 0), object at (-2 + 3, 0, 0) = (1, 0, 0)
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's position
        this.moveX(3); // Move 3 cm to the right to reach object's x-coordinate (1)

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move to the target position (5, 0, 5)
        this.moveX(4); // Move 4 cm to the right to x=5
        o1.setX(this.getX());

        this.moveZ(5); // Move 5 cm forward to z=5
        o1.setZ(this.getZ());

        // Place the object
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object moved from (1, 0, 0) to (5, 0, 5).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "pickup the object situated 2 cm left from origin and place it on the ground 3 cm right from origin"
    public void pickUpAndPlaceObject() {
        this.returnToOrigin(); // Ensure the robot starts at the origin
        ObjectHRI o1 = new ObjectHRI(-2, 0, 0); // Instantiate the object 2 cm to the left of the origin
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's position
        this.moveX(-2); // Move 2 cm to the left to reach the object's x-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the target position (3 cm right from the origin)
        this.moveX(5); // Move 5 cm to the right from x=-2 to x=3
        o1.setX(this.getX());

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("Object moved from (-2, 0, 0) to (3, 0, 0).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin as instructed

    // "Pickup last object placed and place it on the ground 2 cm to the left. do not lift the arm up after placing"
    public void pickUpLastObjectAndPlaceLeft() {
        // Assuming the last placed object is at (3, 0, 0)
        ObjectHRI o1 = new ObjectHRI(3, 0, 0); // Last object placed at (3, 0, 0)
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's position
        this.moveX(3); // Move to object's x-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object 2 cm to the left
        this.moveX(-2); // Move 2 cm to the left
        o1.setX(this.getX());

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object

        System.out.println("Object moved from (3, 0, 0) to (1, 0, 0).");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed

    // "place the object situated at (2,1,2) on the ground 4 cm to the left. Do not return to origin"
    public void placeObjectLeft() {
        // Ensure the robot starts at the origin
        this.returnToOrigin();

        // Instantiate the object located at (2, 1, 2)
        ObjectHRI o1 = new ObjectHRI(2, 1, 2);
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's position
        this.moveX(2); // Move to object's x-coordinate
        this.moveY(-1); // Adjust y-coordinate to object's y level
        this.moveZ(2); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.closeGripper(); // Grip the object
        this.moveY(1); // Lift the object to y=2

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object 4 cm to the left
        this.moveX(-4); // Move 4 cm to the left to x=-2
        o1.setX(this.getX());

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object

        System.out.println("Object moved from (2, 1, 2) to (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ").");
        System.out.println("Final object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed.

    // "Take the object at (1,0,1) and place it at (2,0,1). Then take another object at (3,0,3) and place it one cm to the right"
    public void moveTwoObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // First object at (1, 0, 1)
        ObjectHRI o1 = new ObjectHRI(1, 0, 1);
        this.addObject(o1); // Add the first object to the robot's environment

        // Move to the first object's position
        this.moveX(1); // Move to object's x-coordinate
        this.moveZ(1); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to (2, 0, 1)
        this.moveX(1); // Move to x=2
        o1.setX(this.getX());

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o1.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object
        this.moveY(2); // Raise the arm

        System.out.println("First object moved from (1, 0, 1) to (2, 0, 1).");

        // Return to origin
        this.returnToOrigin();

        // Second object at (3, 0, 3)
        ObjectHRI o2 = new ObjectHRI(3, 0, 3);
        this.addObject(o2); // Add the second object to the robot's environment

        // Move to the second object's position
        this.moveX(3); // Move to object's x-coordinate
        this.moveZ(3); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o2.setX(this.getX());
        o2.setY(this.getY());
        o2.setZ(this.getZ());

        // Move the object 1 cm to the right
        this.moveX(1); // Move to x=4
        o2.setX(this.getX());

        // Place the object on the ground
        this.moveY(-2); // Lower the arm to ground level
        o2.setY(this.getY()); // Update object's Y coordinate
        this.openGripper(); // Release the object

        System.out.println("Second object moved from (3, 0, 3) to (4, 0, 3).");

        // Do not return to origin as per instruction
        System.out.println("Final positions:");
        System.out.println("First object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Second object position: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "Take one object situated at (4,0,2) and place it on top of the object situated at cords (-2,0,3)"
    public void placeObjectOnTop() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // First object at (4, 0, 2)
        ObjectHRI o1 = new ObjectHRI(4, 0, 2);
        this.addObject(o1); // Add the first object to the robot's environment

        // Move to the first object's position
        this.moveX(4); // Move to object's x-coordinate
        this.moveZ(2); // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move to the second object's position at (-2, 0, 3)
        this.moveX(-6); // Move to x=-2
        this.moveZ(1);  // Move to z=3

        // Place the first object on top of the second object
        this.moveY(-2); // Lower the arm to ground level

        // Since the second object is at ground level, the first object will be placed on top
        o1.setX(this.getX());
        o1.setY(this.getY() + 1); // Place it on top of the second object, so y=1
        o1.setZ(this.getZ());

        this.openGripper(); // Release the object

        System.out.println("First object moved from (4, 0, 2) to (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ").");

        // Do not return to origin as per instruction
        System.out.println("Final positions:");
        System.out.println("First object position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed

    // "pickup the object at (-2,0,2) and move it to coordinates (3,0,2). Then pick it up again and move it 2 cm to the left"
    public void moveObjectAndMoveLeft() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // First, move the object from (-2, 0, 2) to (3, 0, 2)
        ObjectHRI o1 = new ObjectHRI(-2, 0, 2);
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's initial position
        this.moveX(-2); // Move to object's x-coordinate
        this.moveZ(2);  // Move to object's z-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object to the new position (3, 0, 2)
        this.moveX(5); // Move to x=3
        // Y coordinate remains the same
        // Z coordinate remains the same
        o1.setX(this.getX());

        // Place the object at the new position
        this.moveY(-2); // Lower arm to ground level
        o1.setY(this.getY());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Print the new position of the object
        System.out.println("Object moved to new position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Pick up the object again from (3, 0, 2)
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move the object 2 cm to the left
        this.moveX(-2); // Move to x=1
        // Y coordinate remains the same
        // Z coordinate remains the same
        o1.setX(this.getX());

        // Place the object at the new position
        this.moveY(-2); // Lower arm to ground level
        o1.setY(this.getY());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Print the final position of the object
        System.out.println("Object moved to final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "Pickup the object 4 cm to the left and place it at coordinates (4,3,2)"
    public void pickupObjectAndPlaceAt4_3_2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Object at (-4, 0, 0)
        ObjectHRI o1 = new ObjectHRI(-4, 0, 0);
        this.addObject(o1); // Add the object to the robot's environment

        // Move to the object's position
        this.moveX(-4); // Move to object's x-coordinate

        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Update object's coordinates to match robot's position
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Move to the new position (4, 3, 2)
        this.moveX(8); // Move to x=4
        this.moveY(1); // Move to y=3
        this.moveZ(2); // Move to z=2

        // Update object's coordinates after moving
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());

        // Place the object at the new position
        this.moveY(-3); // Lower arm to ground level (y=0)
        o1.setY(this.getY());
        this.openGripper(); // Release the object

        // Print the final position of the object
        System.out.println("Object moved to final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Incorrect Y coordinates

    // "From origin, draw a square in the air with a side length of 3"
    public void drawSquareInAir() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move to the starting position of the square (0, 3, 0)
        this.moveY(1); // Move up to y=3

        // Define the side length of the square
        int sideLength = 3;

        // Move to the first corner (3, 3, 0)
        this.moveX(sideLength); // Move to x=3

        // Move to the second corner (3, 3, 3)
        this.moveZ(sideLength); // Move to z=3

        // Move to the third corner (0, 3, 3)
        this.moveX(-sideLength); // Move to x=0

        // Move to the fourth corner (0, 3, 0)
        this.moveZ(-sideLength); // Move to z=0

        // Return to the origin
        this.returnToOrigin();

        // Print the final position of the robot
        System.out.println("Square drawn in the air with side length of " + sideLength + " units.");
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Passed. While unnecessarily adding the moveY(1) line, it correctly managed to draw a square.

    // "There are 3 objects. First is  at coordinates (3,0,1), second is at (4,0,2) and third at (-2,0,2). I want you to pick them and place them on top of each other at coordinates (-5,0,5). The gripper can only hold one object at a time."
    public void stackObjectsAt_neg5_0_5() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Object 1 at (3, 0, 1)
        ObjectHRI o1 = new ObjectHRI(3, 0, 1);
        this.addObject(o1); // Add object to the environment
        // Move to and pick up the first object
        this.moveX(3); // Move to x=3
        this.moveZ(1); // Move to z=1
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the first object to (-5, 0, 5)
        this.moveX(-8); // Move to x=-5
        this.moveZ(4); // Move to z=5
        this.moveY(-2); // Lower arm to ground level (y=0)
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm
        o1.setY(0); // Correct object's Y coordinate after release

        // Return to origin
        this.returnToOrigin();

        // Object 2 at (4, 0, 2)
        ObjectHRI o2 = new ObjectHRI(4, 0, 2);
        this.addObject(o2); // Add object to the environment
        // Move to and pick up the second object
        this.moveX(4); // Move to x=4
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the second object to (-5, 0, 5) and place it on top of the first
        this.moveX(-9); // Move to x=-5
        this.moveZ(3); // Move to z=5
        this.moveY(-1); // Lower arm to place it on top of the first object (y=1)
        o2.setX(this.getX());
        o2.setY(this.getY());
        o2.setZ(this.getZ());
        this.openGripper(); // Release the object
        this.moveY(1); // Lift the arm
        o2.setY(1); // Correct object's Y coordinate after release

        // Return to origin
        this.returnToOrigin();

        // Object 3 at (-2, 0, 2)
        ObjectHRI o3 = new ObjectHRI(-2, 0, 2);
        this.addObject(o3); // Add object to the environment
        // Move to and pick up the third object
        this.moveX(-2); // Move to x=-2
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the third object to (-5, 0, 5) and place it on top of the second
        this.moveX(-3); // Move to x=-5
        this.moveZ(3); // Move to z=5
        this.moveY(0); // Lower arm to place it on top of the second object (y=2)
        o3.setX(this.getX());
        o3.setY(this.getY());
        o3.setZ(this.getZ());
        this.openGripper(); // Release the object

        // Print the final positions of the objects
        System.out.println("Object 1 final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Object 2 final position: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");
        System.out.println("Object 3 final position: (" + o3.getX() + ", " + o3.getY() + ", " + o3.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "There are 2 objects at coordinates (3,0,2) and (-3,0,2). Can you swap them around"
    public void swapObjects_3_0_2_neg3_0_2() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Object 1 at (3, 0, 2)
        ObjectHRI o1 = new ObjectHRI(3, 0, 2);
        this.addObject(o1); // Add object to the environment
        // Move to and pick up the first object
        this.moveX(3); // Move to x=3
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the first object to a temporary position (0, 2, 0)
        this.moveX(-3); // Move to x=0
        this.moveZ(-2); // Move to z=0
        this.moveY(0); // Ensure arm is at the default height
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Return to origin
        this.returnToOrigin();

        // Object 2 at (-3, 0, 2)
        ObjectHRI o2 = new ObjectHRI(-3, 0, 2);
        this.addObject(o2); // Add object to the environment
        // Move to and pick up the second object
        this.moveX(-3); // Move to x=-3
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the second object to the first object's original position (3, 0, 2)
        this.moveX(6); // Move to x=3
        o2.setX(this.getX());
        o2.setY(0); // Ensure the object is on the ground
        o2.setZ(2);
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Return to origin
        this.returnToOrigin();

        // Move the first object from temporary position (0, 2, 0) to second object's original position (-3, 0, 2)
        this.moveX(0); // Move to x=0
        this.moveZ(0); // Move to z=0
        this.moveY(-2); // Lower arm to grip the object
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move to the second object's original position (-3, 0, 2)
        this.moveX(-3); // Move to x=-3
        this.moveZ(2); // Move to z=2
        o1.setX(this.getX());
        o1.setY(0); // Ensure the object is on the ground
        o1.setZ(2);
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Print the final positions of the objects
        System.out.println("Object 1 final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Object 2 final position: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. did not return to origin

    // "Pickup the last two objects moved and place them on top of each other at coords (-5,0,7)"
    public void pickupAndStackLastTwoObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Last object moved was at (-3, 0, 2)
        ObjectHRI o1 = new ObjectHRI(-3, 0, 2);
        this.addObject(o1); // Add object to the environment
        // Move to and pick up the first object
        this.moveX(-3); // Move to x=-3
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the first object to a temporary position (0, 2, 0)
        this.moveX(3); // Move to x=0
        this.moveZ(-2); // Move to z=0
        this.moveY(0); // Ensure arm is at the default height
        o1.setX(this.getX());
        o1.setY(this.getY());
        o1.setZ(this.getZ());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Return to origin
        this.returnToOrigin();

        // Last object moved was at (3, 0, 2)
        ObjectHRI o2 = new ObjectHRI(3, 0, 2);
        this.addObject(o2); // Add object to the environment
        // Move to and pick up the second object
        this.moveX(3); // Move to x=3
        this.moveZ(2); // Move to z=2
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the second object to the first object's temporary position (0, 2, 0)
        this.moveX(-3); // Move to x=0
        this.moveZ(-2); // Move to z=0
        this.moveY(0); // Ensure arm is at the default height
        o2.setX(this.getX());
        o2.setY(this.getY());
        o2.setZ(this.getZ());
        this.openGripper(); // Release the object
        this.moveY(2); // Lift the arm

        // Move to the final stacking position (-5, 0, 7)
        this.moveX(-5); // Move to x=-5
        this.moveZ(7); // Move to z=7
        o1.setX(this.getX()); // Update object's coordinates
        o1.setY(0); // Ensure the object is on the ground
        o1.setZ(this.getZ());
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Place the first object at (-5, 0, 7) and update its position
        o1.setX(this.getX());
        o1.setY(0); // Ensure the object is on the ground
        o1.setZ(this.getZ());
        this.openGripper(); // Release the object

        // Move to the final stacking position for the second object
        this.moveY(-2); // Lower the arm to grip the object
        this.moveX(0); // Ensure x-coordinate is correct
        this.moveZ(0); // Ensure z-coordinate is correct
        this.closeGripper(); // Grip the second object
        this.moveY(2); // Lift the object

        // Stack the second object on top of the first object
        this.moveY(-2); // Lower the arm
        this.moveX(-1); // Adjust x-coordinate
        this.moveZ(-1); // Adjust z-coordinate
        o2.setX(this.getX()); // Update object's coordinates
        o2.setY(this.getY());
        o2.setZ(this.getZ());
        this.openGripper(); // Release the object

        // Print the final positions of the objects
        System.out.println("Object 1 final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Object 2 final position: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. did not return to origin

    // "Move the objects at coordinates (1,0,1) and (-2,0,1) to a new position where they will be placed at (5,0,5) and (6,0,5)"
    public void moveAndPlaceObjects() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Move the first object from (1,0,1) to (5,0,5)
        ObjectHRI o1 = new ObjectHRI(1, 0, 1);
        this.addObject(o1); // Add the object to the environment
        // Move to and pick up the first object
        this.moveX(1); // Move to x=1
        this.moveZ(1); // Move to z=1
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the first object to (5,0,5)
        this.moveX(4); // Move x from 1 to 5
        this.moveZ(4); // Move z from 1 to 5
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setY(this.getY()); // Update object's Y coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object

        // Move the second object from (-2,0,1) to (6,0,5)
        ObjectHRI o2 = new ObjectHRI(-2, 0, 1);
        this.addObject(o2); // Add the object to the environment
        // Move to and pick up the second object
        this.moveX(-2); // Move to x=-2
        this.moveZ(1); // Move to z=1
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the second object to (6,0,5)
        this.moveX(8); // Move x from -2 to 6
        this.moveZ(4); // Move z from 1 to 5
        o2.setX(this.getX()); // Update object's X coordinate
        o2.setY(this.getY()); // Update object's Y coordinate
        o2.setZ(this.getZ()); // Update object's Z coordinate
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object

        // Print the final positions of the objects
        System.out.println("Object 1 final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");
        System.out.println("Object 2 final position: (" + o2.getX() + ", " + o2.getY() + ", " + o2.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. did not return to origin

    // "pickup the object at (1,0,1) and move it to a new Z position at (1,0,5)"
    public void pickupAndMoveObjectToNewZ() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Define the object at (1,0,1)
        ObjectHRI o1 = new ObjectHRI(1, 0, 1);
        this.addObject(o1); // Add the object to the environment

        // Move to the object's position
        this.moveX(1); // Move to x=1
        this.moveZ(1); // Move to z=1

        // Pick up the object
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the object to the new Z position (1,0,5)
        this.moveZ(4); // Move z from 1 to 5
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setY(this.getY()); // Update object's Y coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object

        // Print the final position of the object
        System.out.println("Object final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "pick up the object at coordinates (0,0,0) and move it to a new X position of (4,0,0)."
    public void pickupAndMoveObjectToNewX() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Define the object at (0,0,0)
        ObjectHRI o1 = new ObjectHRI(0, 0, 0);
        this.addObject(o1); // Add the object to the environment

        // Move to the object's position
        // No need to move in X or Z as we are already at (0,0,0)
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the object to the new X position (4,0,0)
        this.moveX(4); // Move x from 0 to 4
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setY(this.getY()); // Update object's Y coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object

        // Print the final position of the object
        System.out.println("Object final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // "pick up the object at coordinates (3,0,1) and move it to a new Y position to coordinates (-2,1,-2)"
    public void pickupAndMoveObjectToNewY() {
        this.returnToOrigin(); // Ensure the robot starts at the origin

        // Define the object at (3,0,1)
        ObjectHRI o1 = new ObjectHRI(3, 0, 1);
        this.addObject(o1); // Add the object to the environment

        // Move to the object's position
        this.moveX(3); // Move to x=3
        this.moveZ(1); // Move to z=1

        // Pick up the object
        if (!this.gripperIsOpen) {
            this.openGripper(); // Open gripper if it's closed
        }
        this.moveY(-2); // Lower arm to ground level
        this.closeGripper(); // Grip the object
        this.moveY(2); // Lift the object

        // Move the object to the new Y position (-2,1,-2)
        this.moveX(-5); // Move x from 3 to -2 (3 - (-2) = 5)
        this.moveY(-1); // Move y from 2 to 1 (2 - 1 = 1)
        this.moveZ(-3); // Move z from 1 to -2 (1 - (-2) = 3)

        // Update object's coordinates
        o1.setX(this.getX()); // Update object's X coordinate
        o1.setY(this.getY()); // Update object's Y coordinate
        o1.setZ(this.getZ()); // Update object's Z coordinate
        this.moveY(-2); // Lower arm to ground level
        this.openGripper(); // Release the object

        // Print the final position of the object
        System.out.println("Object final position: (" + o1.getX() + ", " + o1.getY() + ", " + o1.getZ() + ")");

        // Print the final position of the robot
        System.out.println("Robot's final position: (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
    // Failed. Did not return to origin

    // Tests passed: 4
    // Tests failed: 16



    // Main method to create a robot instance
    public static void main(String[] args) {
        Robot r = new Robot();
    }
}
