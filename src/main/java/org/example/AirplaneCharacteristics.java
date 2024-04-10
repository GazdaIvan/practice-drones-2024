package org.example;

public class AirplaneCharacteristics {

    //@todo check maxVelocity by real limit

    private double maxVelocity; // м/c
    private double acceleration;    // м/c^2
    private double altitudeVelocity;    //м/с
    private double courseVelocity;  //град./с

    public AirplaneCharacteristics(double maxVelocity, double acceleration, double altitudeVelocity, double courseVelocity) {
        this.maxVelocity = maxVelocity;
        this.acceleration = acceleration;
        this.altitudeVelocity = altitudeVelocity;
        this.courseVelocity = courseVelocity;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAltitudeVelocity() {
        return altitudeVelocity;
    }

    public void setAltitudeVelocity(double altitudeVelocity) {
        this.altitudeVelocity = altitudeVelocity;
    }

    public double getCourseVelocity() {
        return courseVelocity;
    }

    public void setCourseVelocity(double courseVelocity) {
        this.courseVelocity = courseVelocity;
    }

    @Override
    public String toString() {
        return "AirplaneCharacteristics{" +
                "maxVelocity=" + maxVelocity +
                ", acceleration=" + acceleration +
                ", altitudeVelocity=" + altitudeVelocity +
                ", courseVelocity=" + courseVelocity +
                '}';
    }
}
