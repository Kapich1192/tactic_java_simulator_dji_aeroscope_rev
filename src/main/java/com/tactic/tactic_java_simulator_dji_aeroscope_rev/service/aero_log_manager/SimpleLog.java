package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.aero_log_manager;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

public interface SimpleLog {
    default void printSimpleLog(Flight flight) {
        String path = app.getSetting().getOrDefault("flight_path","flight_info/") + "Device_"+
                app.getSetting().getOrDefault("device_sn","0QRDJCGR039RJT") + "/";
        String pathFlight = path + "Flight_" + flight.getSn() + "/";
        Date date = new Date(Long.parseLong(flight.getTimeDetected()+"000"));
        String year = "" + (date.getYear() + 1900);
        String month = ""+ (date.getMonth() + 1);
        String day = "" + (date.getDate());
        String hour = "" + (date.getHours());
        String min = "" + (date.getMinutes());
        String sec = "" + (date.getSeconds());
        String title = year + "_" + month + "_" + day + "@" + hour + "_" + min + "_" + sec;
        String fileName = pathFlight + "Flight_" + title + "_flight.log";
        new File(pathFlight).mkdirs();
        File file = new File(fileName);
        moderationFlight(flight);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName),true));
            String temp = makeSimpleLog(flight);
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String makeSimpleLog(Flight flight) {
        String timeStamp = "" + System.currentTimeMillis() / 1000;
        String sn = flight.getSn();
        String homeLatitude = flight.getHomeLatitude() + "";
        String homeLongitude = flight.getHomeLongitude() + "";
        String appLatitude = flight.getAppLatitude() + "";
        String appLongitude = flight.getAppLongitude() + "";
        String curLatitude = flight.getCurrentLatitude() + "";
        String curLongitude = flight.getCurrentLongitude() + "";
        String productType = flight.getProductType() + "";
        String vxNorthSpeed = flight.getVxNorthSpeed() + "";
        String vyEastSpeed = flight.getVyEastSpeed() + "";
        String vzRiseSpeed = flight.getVzRiseSpeed() + "";
        String detectedTime = flight.getTimeDetected();

        String result = "{\"DATA_TYPE\":1," +
                "\"DATA_VALUE\":" +
                "{\"AIRCRAFT_SN\":\"" + sn + "\"" +
                ",\"APP_GPS_LATITUDE\":" + appLatitude + "," +
                "\"APP_GPS_LONGITUDE\":" + appLongitude + "," +
                "\"APP_GPS_TIMESTAMP\":0," +
                "\"CUR_BARO_HEIGHT\":0," +
                "\"CUR_GPS_ABS_HEIGHT\":-17," +
                "\"CUR_POS_LATITUDE\":" + curLatitude + "," +
                "\"CUR_POS_LONGTITUDE\":" + curLongitude + "," +
                "\"HOME_LATITUDE\":" + homeLatitude + "," +
                "\"HOME_LONGITUDE\":" + homeLongitude + "," +
                "\"PRODUCT_TYPE\":" + 68 + "," +
                "\"SEQ_NUM\":3," +
                "\"STATUS_INFO\":\"0000100000000111\"" +
                ",\"UUID\":\"1359829768485543936\"," +
                "\"VX_NORTH_SPEED\":" + vxNorthSpeed + "," +
                "\"VY_EAST_SPEED\":" + vyEastSpeed + "," +
                "\"VZ_RISE_SPEED\":" + vzRiseSpeed + "," +
                "\"YAW\":65.580001831054688}" +
                ",\"DETECT_TIME\":" + detectedTime+"," +
                "\"RF_INDEX\":0," +
                "\"RF_TYPE\":2," +
                "\"TIME_STAMP\":" + timeStamp + "," +
                "\"VERSION\":1" +
                "},\n";

        return result;
    }
    private void moderationFlight(Flight flight) {

        if (app.getSetting().getOrDefault("refresh_current_longitude","false").equals("true")) {
            double newLat = flight.getCurrentLatitude() + 0.000001;
            flight.setCurrentLatitude(newLat);
        }

        if (app.getSetting().getOrDefault("refresh_current_latitude","false").equals("true")) {
            double newLon = flight.getCurrentLongitude() + 0.000001;
            flight.setCurrentLongitude(newLon);
        }

        if (app.getSetting().getOrDefault("refresh_app_latitude","false").equals("true")) {

        }

        if (app.getSetting().getOrDefault("refresh_app_longitude","false").equals("true")) {

        }

        if (app.getSetting().getOrDefault("refresh_home_latitude","false").equals("true")) {

        }

        if (app.getSetting().getOrDefault("refresh_home_longitude","false").equals("true")) {

        }

    }
}
