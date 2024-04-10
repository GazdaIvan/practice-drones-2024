package org.example;

public class WayPoint {

    //@todo - уточнити чим відрізняється швидкість польоту від пРольоту

    private double latitude; // Широта град
    private double longitude; //довгота град
    private double altitude; //висота польоту
    private double flightSpeed; //м/с

    public WayPoint(double latitude, double longitude, double altitude, double flightSpeed) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.flightSpeed = flightSpeed;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getFlightSpeed() {
        return flightSpeed;
    }

    public void setFlightSpeed(double flightSpeed) {
        this.flightSpeed = flightSpeed;
    }

    @Override
    public String toString() {
        return "WayPoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", flightSpeed=" + flightSpeed +
                '}';
    }
}
