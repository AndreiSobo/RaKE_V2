package HRI_chatGPT3_5;

import java.util.ArrayList;

public class ObjectHRI {
    public int x;
    public int y;
    public int z;
    public ArrayList<Integer> objCoords = new ArrayList<>();

    public ObjectHRI(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ObjectHRI() {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    // Implementing Getters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setZ(int z) {
        this.z = z;
    }

    public void setPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public ArrayList<Integer> getPosition () {
        objCoords.add(getX());
        objCoords.add(getY());
        objCoords.add(getZ());
        return objCoords;
    }

    @Override
    public String toString() {
        return "Object at (" + x + ", " + y + ", " + z + ")";
    }
}