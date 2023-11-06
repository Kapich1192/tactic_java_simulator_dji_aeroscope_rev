package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.aero_log_manager;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

public interface SimpleLog {
    default void printSimpleLog(Flight flight) {
        String path = app.getSetting().getOrDefault("flight_path","flight_info/") + "Device_"+
                app.getSetting().getOrDefault("device_sn","SJDVJS432") + "/";
        String fileName = path + "Flight_" + flight.getSn() + ".txt";
        new File(path).mkdirs();
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName),true));
            String temp = makeLog(flight);
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String makeLog(Flight flight) {
        String timeStamp = "" + System.currentTimeMillis() / 1000;
        String result = "{\"DATA_TYPE\":1," +
                "\"DATA_VALUE\":" +
                "{\"AIRCRAFT_SN\":\"0M6CH7SR0A1AY9\"" +
                ",\"APP_GPS_LATITUDE\":0," +
                "\"APP_GPS_LONGITUDE\":0," +
                "\"APP_GPS_TIMESTAMP\":0," +
                "\"CUR_BARO_HEIGHT\":0," +
                "\"CUR_GPS_ABS_HEIGHT\":-17," +
                "\"CUR_POS_LATITUDE\":0," +
                "\"CUR_POS_LONGTITUDE\":0," +
                "\"HOME_LATITUDE\":0," +
                "\"HOME_LONGITUDE\":0," +
                "\"PRODUCT_TYPE\":41," +
                "\"SEQ_NUM\":3," +
                "\"STATUS_INFO\":\"0000100000000111\"" +
                ",\"UUID\":\"1359829768485543936\"," +
                "\"VX_NORTH_SPEED\":0," +
                "\"VY_EAST_SPEED\":0," +
                "\"VZ_RISE_SPEED\":4," +
                "\"YAW\":65.580001831054688}" +
                ",\"DETECT_TIME\":1684938272," +
                "\"RF_INDEX\":0," +
                "\"RF_TYPE\":2," +
                "\"TIME_STAMP\":" + timeStamp + "," +
                "\"VERSION\":1" +
                "},\n";

        return result;
    }
}
