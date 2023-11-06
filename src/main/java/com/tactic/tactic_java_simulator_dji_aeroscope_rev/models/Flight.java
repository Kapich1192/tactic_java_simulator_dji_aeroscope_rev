package com.tactic.tactic_java_simulator_dji_aeroscope_rev.models;

public class Flight {
    private String sn;
    private double currentLatitude;
    private double currentLongitude;
    private double appLatitude;
    private double appLongitude;
    private double homeLatitude;
    private double homeLongitude;

    public Flight() {

    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public double getAppLatitude() {
        return appLatitude;
    }

    public void setAppLatitude(double appLatitude) {
        this.appLatitude = appLatitude;
    }

    public double getAppLongitude() {
        return appLongitude;
    }

    public void setAppLongitude(double appLongitude) {
        this.appLongitude = appLongitude;
    }

    public double getHomeLatitude() {
        return homeLatitude;
    }

    public void setHomeLatitude(double homeLatitude) {
        this.homeLatitude = homeLatitude;
    }

    public double getHomeLongitude() {
        return homeLongitude;
    }

    public void setHomeLongitude(double homeLongitude) {
        this.homeLongitude = homeLongitude;
    }
}
