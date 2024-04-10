package org.example;

public class TemporaryPoint {

    //Довгота (кут між площиною меридіану в точці спостереження та нульовим (Гринвіч) меридіаном),
    // Широта (кут між прямовисною лінією та площиною екватора) визначають положення точки на поверхні Землі.
    // Вимірюються в градусах (°), довгота — від -180° до 0° на захід та від 0° до 180° на схід від Гринвіча,
    // широта — від 0° до 90° на північ, від 0° до −90° на південь від екватора.

    //інтервал між точками 1 с!!!
    private double latitude; // Широта град
    private double longitude; //довгота град
    private double altitude; //висота польоту
    private double velocity; // м/c
    private double course;  //град

    public TemporaryPoint(double latitude, double longitude, double altitude, double velocity, double course) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.velocity = velocity;
        this.course = course;
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

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TemporaryPoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", velocity=" + velocity +
                ", course=" + course +
                '}';
    }
}
