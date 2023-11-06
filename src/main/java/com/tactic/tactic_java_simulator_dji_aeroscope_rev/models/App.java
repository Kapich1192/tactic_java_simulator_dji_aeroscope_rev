package com.tactic.tactic_java_simulator_dji_aeroscope_rev.models;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator.Configurator;
import com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator.FlightConfigurator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class App implements Configurator, FlightConfigurator {
    private HashMap<String,String> setting;
    private ArrayList<Flight> flights;

    public App() {

    }

    public App(HashMap<String, String> setting, ArrayList<Flight> flights) {
        this.setting = setting;
        this.flights = flights;
    }

    public void initialize() {
        setting = new HashMap<>() {{
            put("device_sn","KSFSIBJ23458");
            put("flight_source","flights/");
            put("flight_path","flight_info/");

            put("refresh_current_latitude", "true");
            put("refresh_current_longitude", "true");

            put("refresh_app_latitude", "true");
            put("refresh_app_longitude", "true");

            put("refresh_home_latitude", "true");
            put("refresh_home_longitude", "true");

            put("status_simple_log","true");
            put("status_empty_sn_log","false");

        }};

        flights = new ArrayList<>();
    }
    public HashMap<String, String> getSetting() {
        return setting;
    }

    public void setSetting(HashMap<String, String> setting) {
        this.setting = setting;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "App{" +
                "\nsetting = \n" + setting +
                ",\n flights = \n" + flights +
                "\n}";
    }
}
