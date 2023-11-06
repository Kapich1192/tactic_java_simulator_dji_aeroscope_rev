package com.tactic.tactic_java_simulator_dji_aeroscope_rev.models;

public class Flight {
    private String sn;
    private String appGpsTimeStamp;
    private double appLatitude;
    private double appLongitude;
    private double currentBaroHeight;
    private double currentGpsApsHeight;
    private double currentLatitude;
    private double currentLongitude;
    private double homeLatitude;
    private double homeLongitude;
    private int productType;
    private double seqNum;
    private double vxNorthSpeed;
    private double vyEastSpeed;
    private double vzRiseSpeed;
    private String timeDetected;

    public Flight() {
        timeDetected = System.currentTimeMillis() / 1000 + "";
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAppGpsTimeStamp() {
        return appGpsTimeStamp;
    }

    public void setAppGpsTimeStamp(String appGpsTimeStamp) {
        this.appGpsTimeStamp = appGpsTimeStamp;
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

    public double getCurrentBaroHeight() {
        return currentBaroHeight;
    }

    public void setCurrentBaroHeight(double currentBaroHeight) {
        this.currentBaroHeight = currentBaroHeight;
    }

    public double getCurrentGpsApsHeight() {
        return currentGpsApsHeight;
    }

    public void setCurrentGpsApsHeight(double currentGpsApsHeight) {
        this.currentGpsApsHeight = currentGpsApsHeight;
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public double getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(double seqNum) {
        this.seqNum = seqNum;
    }

    public double getVxNorthSpeed() {
        return vxNorthSpeed;
    }

    public void setVxNorthSpeed(double vxNorthSpeed) {
        this.vxNorthSpeed = vxNorthSpeed;
    }

    public double getVyEastSpeed() {
        return vyEastSpeed;
    }

    public void setVyEastSpeed(double vyEastSpeed) {
        this.vyEastSpeed = vyEastSpeed;
    }

    public double getVzRiseSpeed() {
        return vzRiseSpeed;
    }

    public void setVzRiseSpeed(double vzRiseSpeed) {
        this.vzRiseSpeed = vzRiseSpeed;
    }

    public String getTimeDetected() {
        return timeDetected;
    }

    public void setTimeDetected(String timeDetected) {
        this.timeDetected = timeDetected;
    }
}
