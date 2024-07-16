package HRI;

import java.util.ArrayList;

public class ObjectHRI {
    private double x;
    private double y;
    private double z;
    public ArrayList<Double> objCoords = new ArrayList<>();

    public ObjectHRI(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    // Implementing Getters
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public void setPosition(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public ArrayList<Double> getPosition () {
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